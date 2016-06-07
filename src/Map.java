/**
 * Created by dell on 2016/4/24.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

public class Map {





        private int height;
        private int width;
         ArrayList<Cell> cells = new ArrayList<Cell>();
    ArrayList<Cell> useCell = new ArrayList<Cell>();


        public Map( int width,int height) {
            super();
            this.height = height;
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }


        public Cell getCell(int x, int y){
            //System.out.println(cells.size());
            return cells.stream().filter(
                    item -> (item.getX() == x && item.getY()==y))
                    .findFirst().orElse(createCell(x,y));
        }
    public Cell get(int x, int y){

        Iterator<Cell> it = cells.iterator();
        while (it.hasNext()) {
            Cell str = it.next();
            if(str.getX() ==x&&str.getY()==y){
                return str;
            }
        }
            return null;

    }

        private Cell createCell(int x, int y) {
            Cell c = new Cell(x,y);
            cells.add(c);
           // System.out.print("ok ");
            return c;
        }

        public String toTexture() {
            StringBuffer sb = new StringBuffer();
            for(int y=0;y<height;y++){
                for(int x=0;x<width;x++){
                    sb.append(get(x,y).toTextual());
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }


