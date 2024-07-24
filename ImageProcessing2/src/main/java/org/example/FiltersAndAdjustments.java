package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FiltersAndAdjustments {
    public FiltersAndAdjustments(){

    }
    public BufferedImage adjutByScale(BufferedImage image){
        double aspectRatio = (double) image.getWidth() / image.getHeight();

        int newWidth = 1000;
        int newHeight =600;

        // שמירה על יחס האורך והרוחב המקורי
        if (1000 / (double) 600 < aspectRatio) {
            newHeight = (int) (1000 / aspectRatio);
        } else {
            newWidth = (int) (600 * aspectRatio);
        }

        // יצירת תמונה חדשה בגודל המחושב
        Image tmp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        // ציור התמונה המכווצת לתוך התמונה החדשה
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }
    public BufferedImage colorShiftRight(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                Color shifted = new Color(current.getGreen(), current.getBlue(), current.getRed());
                image.setRGB(x, y, shifted.getRGB());
            }
        }
        return image;
    }
    public BufferedImage colorShiftLeft(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                Color shifted = new Color(current.getBlue(), current.getRed(), current.getGreen());
                image.setRGB(x, y, shifted.getRGB());
            }
        }
        return image;
    }
    public BufferedImage BlackToWhite(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            int sum=0;
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                sum=current.getBlue()+current.getRed()+current.getGreen();
                if(sum/3<128)
                {
                    image.setRGB(x,y,new Color(255,255,255).getRGB());
                }
                else
                {
                    image.setRGB(x,y,new Color(0,0,0).getRGB());
                }

            }
        }
        return image;
    }
    public BufferedImage GrayScale(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            int sum=0;
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                sum=current.getBlue()+current.getRed()+current.getGreen();

                    image.setRGB(x,y,new Color(sum/3,sum/3,sum/3).getRGB());


            }
        }
        return image;
    }
    public BufferedImage Elminitred(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            int sum=0;
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                sum=current.getBlue()+current.getRed()+current.getGreen();

                image.setRGB(x,y,new Color(0,current.getGreen(),current.getBlue()).getRGB());


            }
        }
        return image;
    }
    public BufferedImage Postorize(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            int sum=0;
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                sum=current.getBlue()+current.getRed()+current.getGreen();

                image.setRGB(x,y,new Color((current.getRed() >127) ? 255:0,(current.getGreen() >127) ? 255:0,(current.getBlue() >127) ? 255:0).getRGB());


            }
        }
        return image;
    }

    public  BufferedImage Ligher(BufferedImage image) {
        BufferedImage brightenedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb, true);

                // Adjust the brightness of each color component
                int red = (int) Math.min(color.getRed() * 1.2, 255);
                int green = (int) Math.min(color.getGreen() * 1.2, 255);
                int blue = (int) Math.min(color.getBlue() * 1.2, 255);

                // Set the new color
                Color brightenedColor = new Color(red, green, blue, color.getAlpha());
                brightenedImage.setRGB(x, y, brightenedColor.getRGB());
            }
        }

        return brightenedImage;
    }
    public BufferedImage Darker(BufferedImage image) {
        BufferedImage brightenedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb, true);

                // Adjust the brightness of each color component
                int red = (int) Math.min(color.getRed() * 0.8, 255);
                int green = (int) Math.min(color.getGreen() * 0.8, 255);
                int blue = (int) Math.min(color.getBlue() * 0.8, 255);

                // Set the new color
                Color brightenedColor = new Color(red, green, blue, color.getAlpha());
                brightenedImage.setRGB(x, y, brightenedColor.getRGB());
            }
        }

        return brightenedImage;
    }
    public BufferedImage Negetive(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            int sum=0;
            for (int y = 0; y < image.getHeight(); y++) {
                Color current = new Color(image.getRGB(x, y));
                sum=current.getBlue()+current.getRed()+current.getGreen();

                image.setRGB(x,y,new Color(255-current.getRed(),255-current.getGreen(),255-current.getBlue()).getRGB());


            }
        }
        return image;
    }
    public BufferedImage showBorders(BufferedImage image) {
        final int MIN_DIFF_FOR_BORDER = 30;
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage borderImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                boolean border = false;
                Color current = new Color(image.getRGB(x, y));

                if (x + 1 < width) {
                    Color right = new Color(image.getRGB(x + 1, y));
                    int redDiff = Math.abs(current.getRed() - right.getRed());
                    int greenDiff = Math.abs(current.getGreen() - right.getGreen());
                    int blueDiff = Math.abs(current.getBlue() - right.getBlue());
                    int totalDiff = redDiff + greenDiff + blueDiff;
                    if (MIN_DIFF_FOR_BORDER < totalDiff) {
                        border = true;
                    }
                }

                if (!border && y + 1 < height) {
                    Color down = new Color(image.getRGB(x, y + 1));
                    int redDiff = Math.abs(current.getRed() - down.getRed());
                    int greenDiff = Math.abs(current.getGreen() - down.getGreen());
                    int blueDiff = Math.abs(current.getBlue() - down.getBlue());
                    int totalDiff = redDiff + greenDiff + blueDiff;
                    if (MIN_DIFF_FOR_BORDER < totalDiff) {
                        border = true;
                    }
                }

                if (border) {
                    borderImage.setRGB(x, y, Color.BLUE.getRGB());
                } else {
                    borderImage.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        return borderImage;
    }
}
