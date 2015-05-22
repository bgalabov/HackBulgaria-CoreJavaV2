package com.hackbulgaria.corejava;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class ToasterReminder {
    
    public static void setReminder(int minutesToStay, int minutesDelay) throws IOException, InterruptedException {
        Image image = ImageIO.read(new File(".\\doge_glasses.PNG"));
        Toaster toaster = new Toaster();
        toaster.setToasterWidth(image.getHeight(null));
        toaster.setToasterHeight(image.getHeight(null));
        toaster.setStep(1);
        toaster.setDisplayTime(minutesToStay*60*1000);
        toaster.setBackgroundImage(image);
        toaster.setMessageColor(Color.ORANGE);
        toaster.setToasterMessageFont(new Font("Comic Sans MS", Font.BOLD, 70));
        toaster.setBorderColor(new Color(1, 1, 1, 100));
        toaster.setMargin(50);
        while(true) {
            Thread.currentThread().sleep(minutesDelay*60*1000);
            toaster.showToaster("So close... such sharp... no see...\n Much break... wow");
        }
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        setReminder(1, 2);
    }
    
   

}
