package island;

public class IslandLocation {
    int side = 1;
    Island[][] island = new Island[side][side];
public void initialize(){
    for (int i = 0; i < island.length ; i++) {
        for (int j = 0; j < island[i].length; j++) {
            island[i][j]= new Island();
        }

    }
}
    public void printIslandStatistics(){
        for (int i = 0; i <island.length ; i++) {
            for (int j = 0; j < island[i].length; j++) {
                System.out.println(island[i][j].getClass().getSimpleName());
                System.out.println("Ячейка: "+ i +" " + j);
                System.out.println("Растений: "+island[i][j].plantsGrow());
                System.out.println("Травоядных: "+island[i][j].herbivoresInitialize());
                System.out.println("Хищников: "+island[i][j].predatorInitialize());

            }
        }

        }
}
