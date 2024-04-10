public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int[] iii = array2d[0];
        int sum = 0;
        for(int i : iii){
            sum += i;
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        int sum;
        for(int[] array1d : array2d){
            sum = 0;
            for(int i : array1d){
                sum += i;
            }
            if(sum != checkSum){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        int maxWidth = array2d.length;
        int length = array2d[0].length;
        int idx;
        int sum;
        for(int i = 0; i < length; i++){
            idx = 0;
            sum = 0;
            for(int ii = 0; ii < maxWidth; ii++){
                sum += array2d[ii][i];
            }
            if(sum != checkSum){
                return false;
            }


        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int sum = 0;
        int x = 0;
        int maxX = array2d[0].length;
        int maxY = array2d.length;

        for(int y = 0; y < maxY; y++){
            sum += array2d[y][x];
            x++;
        }
        if(sum != checkSum){
            return false;
        }
        sum = 0;
        x = maxX - 1;
        for(int y = maxY - 1; y >= 0; y--){
            sum += array2d[y][x];
            x--;
        }
        if(sum != checkSum){
            return false;
        }
        return true;

    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int sum = calculateCheckSum(array2d);
        if(magicRows(array2d, sum) && magicColumns(array2d, sum) && magicDiagonals(array2d, sum)){
            return true;
        }
        return false;
    }

}
