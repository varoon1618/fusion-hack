package org.example.Images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageLoader {
  private BufferedImage image;
  private BufferedImage impassableBlock;
  private BufferedImage passableBlock;
  private BufferedImage destinationBlock;
  private final BufferedImage[][] animations = new BufferedImage[12][8];
  private BufferedImage[][] walkingAnimations;
  private BufferedImage[][] idleAnimations;
  public ImageLoader(){
    importImage();
    loadAnimations();
  }
  public void importImage(){
    InputStream is = getClass().getResourceAsStream("/cat_sprite.png");
    try {
      image = ImageIO.read(is);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    is = getClass().getResourceAsStream("/grasspath.jpg");
    try {
      impassableBlock = ImageIO.read(is);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    is = getClass().getResourceAsStream("/stonepath1.jpg");
    try {
      passableBlock = ImageIO.read(is);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    is = getClass().getResourceAsStream("/destination.png");
    try {
      destinationBlock= ImageIO.read(is);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void loadAnimations() {

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 12; j++) {
        animations[j][i] = image.getSubimage(j * 32, i * 32, 32, 32);
      }
    }

    BufferedImage[] walkRightAnimation = new BufferedImage[4];
    walkRightAnimation[0] = animations[0][2];
    walkRightAnimation[1] = animations[1][2];
    walkRightAnimation[2] = animations[2][2];
    walkRightAnimation[3] = animations[1][2];

    BufferedImage[] walkUpAnimation = new BufferedImage[4];
    walkUpAnimation[0] = animations[0][3];
    walkUpAnimation[1] = animations[1][3];
    walkUpAnimation[2] = animations[2][3];
    walkUpAnimation[3] = animations[1][3];

    BufferedImage[] walkLeftAnimation = new BufferedImage[4];
    walkLeftAnimation[0] = animations[0][1];
    walkLeftAnimation[1] = animations[1][1];
    walkLeftAnimation[2] = animations[2][1];
    walkLeftAnimation[3] = animations[1][1];

    BufferedImage[] walkDownAnimation = new BufferedImage[4];
    walkDownAnimation[0] = animations[0][0];
    walkDownAnimation[1] = animations[1][0];
    walkDownAnimation[2] = animations[2][0];
    walkDownAnimation[3] = animations[1][0];

    walkingAnimations = new BufferedImage[4][4];
    walkingAnimations[0] = walkLeftAnimation;
    walkingAnimations[1] = walkUpAnimation;
    walkingAnimations[2] = walkRightAnimation;
    walkingAnimations[3] = walkDownAnimation;

    BufferedImage[] idleSouthAnimation = new BufferedImage[4];
    idleSouthAnimation[0] = animations[6][4];
    idleSouthAnimation[1] = animations[7][4];
    idleSouthAnimation[2] = animations[8][4];
    idleSouthAnimation[3] = animations[7][4];

    BufferedImage[] idleWestAnimation = new BufferedImage[4];
    idleWestAnimation[0] = animations[0][5];
    idleWestAnimation[1] = animations[0][6];
    idleWestAnimation[2] = animations[0][7];
    idleWestAnimation[3] = animations[0][6];

    BufferedImage[] idleEastAnimation = new BufferedImage[4];
    idleEastAnimation[0] = animations[3][6];
    idleEastAnimation[1] = animations[3][6];
    idleEastAnimation[2] = animations[3][6];
    idleEastAnimation[3] = animations[3][6];

    BufferedImage[] idleNorthAnimation = new BufferedImage[4];
    idleNorthAnimation[0] = animations[6][5];
    idleNorthAnimation[1] = animations[7][5];
    idleNorthAnimation[2] = animations[8][5];
    idleNorthAnimation[3] = animations[7][5];

    idleAnimations = new BufferedImage[4][4];
    idleAnimations[0] = idleWestAnimation;
    idleAnimations[1] = idleNorthAnimation;
    idleAnimations[2] = idleEastAnimation;
    idleAnimations[3] = idleSouthAnimation;

  }

  public BufferedImage getGrassPath(){
    return impassableBlock;
  }

  public BufferedImage getStonePath(){
    return passableBlock;
  }

  public BufferedImage getDestination(){
    return destinationBlock;
  }

  public BufferedImage[][] getWalkingAnimations(){
    return walkingAnimations;
  }

  public BufferedImage[][] getIdleAnimations(){
    return idleAnimations;
  }
}
