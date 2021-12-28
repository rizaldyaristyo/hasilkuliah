//DISCONTINUED


package com.discontinued.sudoku;

import java.util.Random;

class Logic{
    int[] templateInt = {1,2,3,4,5,6,7,8,9};
    int[] possibleInt = {1,2,3,4,5,6,7,8,9};
    public void eliminate(int toDelete){
        for (int a=0;a<9;a++) if (possibleInt[a]==toDelete) possibleInt[a]=0;
    }
    public void cyclePossible(){
        int n = templateInt.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            int holder = templateInt[i];
            templateInt[i] = templateInt[change];
            templateInt[change] = holder;
        }
        System.arraycopy(templateInt, 0, possibleInt, 0, possibleInt.length);
    }
    public int possibility () {
        for (int a = 0; a < 9; a++){
            if (possibleInt[a] != 0) {
                int maybeThis = possibleInt[a];
                eliminate(possibleInt[a]);
                return maybeThis;
            }
        }
        return 0;
    }
}

class Sudoku{
    public void print(int[][] papanSudoku){
        int a=0;
        System.out.println("+-------+-------+-------+");
        for (int b=0;b<9;b++){
            if (a<3) a++;
            else if (a==3) {
                System.out.println("+-------+-------+-------+");
                a=1;
            }
            for (int c=0;c<9;c++) {
                if (c==0) System.out.print("| ");
                if (papanSudoku[b][c]!=0) System.out.print(papanSudoku[b][c]+" ");
                else System.out.print("  ");
                if (c==2||c==5||c==8) System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println("+-------+-------+-------+\n\n");
    }

    public int[][] init(){
        return new int[][]{
           {5, 3, 0, 0, 7, 0, 0, 0, 0},
           {6, 0, 0, 1, 9, 5, 0, 0, 0},
           {0, 9, 8, 0, 0, 0, 0, 6, 0},
           {8, 0, 0, 0, 6, 0, 0, 0, 3},
           {4, 0, 0, 8, 0, 3, 0, 0, 1},
           {7, 0, 0, 0, 2, 0, 0, 0, 6},
           {0, 6, 0, 0, 0, 0, 2, 8, 0},
           {0, 0, 0, 4, 1, 9, 0, 0, 5},
           {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
    }

    public void solve(int[][] papanSudoku){
        //solve
        papanSudoku=init();
        boolean empties=true;
        Logic logic = new Logic();
        while (empties){
            empties=false;
            print(papanSudoku);
            for (int b = 0; b < 9; b++) {
                for (int c = 0; c < 9; c++) {
                    if (papanSudoku[b][c] == 0) {
                        int possibility = logic.possibility();
                        for (int d = 0; d < 9; d++) {
                            //System.out.println(d);
                            if (possibility == papanSudoku[b][d]) {
                                //System.out.println(possibility + "=" + papanSudoku[b][d] + "at" + b+","+d);
                                logic.eliminate(possibility);
                                empties=true;
                                possibility = logic.possibility();
                            } else if (possibility == papanSudoku[d][c]) {
                                //System.out.println(possibility + "=" + papanSudoku[d][c] + "at" + d+","+c);
                                logic.eliminate(possibility);
                                empties=true;
                                possibility = logic.possibility();
                            }
                            if (possibility==0){
                                logic.cyclePossible();
                                empties=true;
                                if (possibility == papanSudoku[b][d]) {
                                    System.out.println(possibility + "=" + papanSudoku[b][d] + "at" + b+","+d);
                                    logic.eliminate(possibility);
                                    possibility = logic.possibility();
                                } else if (possibility == papanSudoku[d][c]) {
                                    System.out.println(possibility + "=" + papanSudoku[d][c] + "at" + d+","+c);
                                    logic.eliminate(possibility);
                                    possibility = logic.possibility();
                                }
                            }
                        }
                        papanSudoku[b][c] = possibility;
                    }
                }
            }
        }
        int errors=0;
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (errors>2){
                    System.out.println("resolve!");
                    solve(papanSudoku);
                    return;
                }
                errors = 0;
                for (int c = 0; c < 9; c++) {
                    if (papanSudoku[a][b]==papanSudoku[a][c]){
                        errors++;
                    } else if (papanSudoku[a][b]==papanSudoku[c][b]){
                        errors++;
                    }
                }
            }
        }


        System.out.println("SOLVED!");
        print(papanSudoku);
    }
}

public class Main {
    public static void main(String[] args) {
        //init
        Sudoku sudoku = new Sudoku();
        int[][] papanSudoku=sudoku.init();
        sudoku.solve(papanSudoku);
    }
}
