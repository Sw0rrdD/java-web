package com.bank.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ValidateCodeUtil {
	private static final long serialVersionUID = 1L;
	private static final Font mFont = new Font("Arial Black", Font.PLAIN, 16);
	private static final int IMG_WIDTH = 70;
	private static final int IMG_HEIGTH = 18;
	private String code = "";
	public BufferedImage getImage(){
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGTH,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(1, 1, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		g.setColor(new Color(102, 102, 102));
		g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 80; i++) {
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g.drawLine(x, y, x + xl, y + yl);
		}
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 80; i++) {
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(12) + 1;
			int yl = random.nextInt(6) + 1;
			g.drawLine(x, y, x - xl, y - yl);
		}
		g.setFont(mFont);
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String tmp = String.valueOf(random.nextInt(10));
			sRand += tmp;
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(tmp, 15 * i + 10, 15);
		}
		this.setCode(sRand);
		return image;
	}
	private  Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	@SuppressWarnings("unused")
	private  String getRandomChar() {
		int rand = (int) Math.round(Math.random() * 2);
		long itmp = 0;
		char ctmp = '\u0000';
		switch (rand) {
		case 1:
			itmp = Math.round(Math.random() * 25 + 65);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
		case 2:
			itmp = Math.round(Math.random() * 25 + 97);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);
		default:
			itmp = Math.round(Math.random() * 9);
			return itmp + "";
		}
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
