package island;

public class Island {
    int side = 2;
    IslandLocation[][] island = new IslandLocation[side][side];
public void initialize(){
    for (int i = 0; i < island.length ; i++) {
        for (int j = 0; j < island[i].length; j++) {
            island[i][j]= new IslandLocation();
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
