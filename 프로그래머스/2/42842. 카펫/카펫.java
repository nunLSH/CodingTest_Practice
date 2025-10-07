class Solution {
    public int[] solution(int brown, int yellow) {
        
        int w = 0, h = 0;
        for (int y = 1; y < 2500; y++){
            if((brown + 4) * y / 2 - y * y - brown == yellow){
                h = y;
                w = brown / 2 + 2 - h;
                if (w >= h)
                    break;
            }
        }
        
        return new int[]{w, h};
    }
}