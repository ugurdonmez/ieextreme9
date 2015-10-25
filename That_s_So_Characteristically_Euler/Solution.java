/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package That_s_So_Characteristically_Euler;

import java.util.Scanner;

/**
 *
 * @author ugurdonmez
 */
public class Solution {
    
    public static void main ( String [] args ) {
        
        Scanner sc = new Scanner(System.in);
        
        int test_case = Integer.parseInt(sc.nextLine());
        
        for ( int i = 0 ; i < test_case ; i++ ) {
            
            int row = Integer.parseInt(sc.nextLine());
            int coloumn = Integer.parseInt(sc.nextLine());
            
            Image image = new Image(row, coloumn, sc);
            
            //System.out.println("--------");
            
            //System.out.println(image);
            
            //System.out.println(image.getConnectedRegion());
            //System.out.println(image.getHoles());
            
            System.out.println(image.getConnectedRegion() - image.getHoles());
            
        }
        
    }
    
}

class Image {
    
    int row;
    int coloumn;
    
    Pixel [][] pixels;

    public Image(int row, int coloumn, Scanner sc) {
        this.row = row;
        this.coloumn = coloumn;
        
        pixels = new Pixel[row][coloumn];
        
        for ( int x = 0 ;  x < row ; x++ ) {
            
            String line = sc.nextLine();
            
            for ( int y = 0 ; y < coloumn ; y++ ) {
                if ( line.charAt(y) == 'O' ) {
                    pixels[x][y] = new Pixel(PixelType.WHITE, x, y);
                } else if ( line.charAt(y) == 'X' ) {
                    pixels[x][y] = new Pixel(PixelType.BLACK, x, y);
                }
            }
        }
        
    }
    

    
    public int getHoles() {
        
        determineCorners();
        
        int size = 0;
        
        Pixel pixel = getEmptyTypeWhite();
        
        while ( pixel != null ) {
            
            size++;
            DFSWhite(pixel);
            pixel = getEmptyTypeWhite();
            
        }        
        return size;
    }
    
    public int getConnectedRegion () {
        
        int size = 0;
        
        Pixel pixel = getEmptyTypeBlack();
        
        while ( pixel != null ) {
            
            size++;
            DFSBlack(pixel);
            pixel = getEmptyTypeBlack();
            
        }        
        return size;
        
    }
    
    private void determineCorners () {
        
        // top bottom
        for ( int i = 0 ; i < coloumn ; i++ ) {
            DFSWhite(pixels[0][i]);
            DFSWhite(pixels[row-1][i]);
        }
        
        // left right
        for ( int i = 1 ; i < row - 1 ; i++ ) {
            DFSWhite(pixels[i][0]);
            DFSWhite(pixels[i][coloumn-1]);
        }
         
        
    }
    
    private Pixel getEmptyTypeWhite() {
        
        for ( int x = 0 ;  x < row ; x++ ) {
            for ( int y = 0 ; y < coloumn ; y++ ) {
                if ( pixels[x][y].type == PixelType.WHITE && pixels[x][y].isVisited == DFSType.EMPTY ) {
                    return pixels[x][y];
                }
            }
        }
        
        return null;
    }
    
    private Pixel getEmptyTypeBlack() {
        
        for ( int x = 0 ;  x < row ; x++ ) {
            for ( int y = 0 ; y < coloumn ; y++ ) {
                if ( pixels[x][y].type == PixelType.BLACK && pixels[x][y].isVisited == DFSType.EMPTY ) {
                    return pixels[x][y];
                }
            }
        }
        
        return null;
    }
    
    private Pixel getLeft ( Pixel pixel ) {
        if ( pixel.y - 1 >= 0 ) {
            return pixels[pixel.x][pixel.y - 1];
        } else {
            return null;
        }
    }
    
    private Pixel getRight ( Pixel pixel ) {
        if ( pixel.y + 1 < coloumn ) {
            return pixels[pixel.x][pixel.y + 1];
        } else {
            return null;
        }
    }
    
    private Pixel getUp ( Pixel pixel ) {
        if ( pixel.x - 1 >= 0 ) {
            return pixels[pixel.x-1][pixel.y];
        } else {
            return null;
        }
    }
    
    private Pixel getDown ( Pixel pixel ) {
        if ( pixel.x + 1 < row ) {
            return pixels[pixel.x+1][pixel.y];
        } else {
            return null;
        }
    }
    
    private Pixel getUpLeft ( Pixel pixel ) {
        Pixel p = getUp(pixel);
        if ( p != null ) {
            return getLeft(p);
        } else {
            return null;
        }
    }
    
    private Pixel getUpRight ( Pixel pixel ) {
        Pixel p = getUp(pixel);
        if ( p != null ) {
            return getRight(p);
        } else {
            return null;
        }
    }
    
    private Pixel getDownLeft ( Pixel pixel ) {
        Pixel p = getDown(pixel);
        if ( p != null ) {
            return getLeft(p);
        } else {
            return null;
        }
    }
    
    private Pixel getDownRight ( Pixel pixel ) {
        Pixel p = getDown(pixel);
        if ( p != null ) {
            return getRight(p);
        } else {
            return null;
        }
    }
    
    
    private void DFSWhite ( Pixel pixel ) {
        
        if ( pixel == null ) {
            return;
        }
        
        if ( pixel.type == PixelType.BLACK ) {
            return;
        }
        
        if ( pixel.isVisited == DFSType.VISITED ) {
            return;
        }
        
        if ( pixel.isVisited == DFSType.VISITING ) {
            return;
        }
        
        pixel.isVisited = DFSType.VISITING;
        
        // for each adj call dfs
        DFSWhite(getDown(pixel));
        DFSWhite(getUp(pixel));
        DFSWhite(getRight(pixel));
        DFSWhite(getLeft(pixel));
        
        pixel.isVisited = DFSType.VISITED;
        
    }
    
    private void DFSBlack ( Pixel pixel ) {
        
        if ( pixel == null ) {
            return;
        }
        
        if ( pixel.type == PixelType.WHITE ) {
            return;
        }
        
        if ( pixel.isVisited == DFSType.VISITED ) {
            return;
        }
        
        if ( pixel.isVisited == DFSType.VISITING ) {
            return;
        }
        
        pixel.isVisited = DFSType.VISITING;
        
        // for each adj call dfs
        DFSBlack(getDown(pixel));
        DFSBlack(getUp(pixel));
        DFSBlack(getRight(pixel));
        DFSBlack(getLeft(pixel));
        DFSBlack(getUpLeft(pixel));
        DFSBlack(getUpRight(pixel));
        DFSBlack(getDownLeft(pixel));
        DFSBlack(getDownRight(pixel));
        
        
        pixel.isVisited = DFSType.VISITED;
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        for ( int x = 0 ;  x < row ; x++ ) {
            for ( int y = 0 ; y < coloumn ; y++ ) {
                sb.append(pixels[x][y]);
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}

enum DFSType {
    VISITING, VISITED, EMPTY;   
}

enum PixelType {
    BLACK, WHITE;
}


class Pixel {
    PixelType type;
    int x;
    int y;
    DFSType isVisited;
    

    public Pixel(PixelType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.isVisited = DFSType.EMPTY;
    }
    
    @Override
    public String toString() {
        if ( type == PixelType.BLACK ) {
            return "X";
        } else {
            return "O";
        }
    }
}
