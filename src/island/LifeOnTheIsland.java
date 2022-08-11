package island;

public class LifeOnTheIsland implements Runnable{
    IslandLocation[][] islandResidents;
    public LifeOnTheIsland(IslandLocation[][] islandResidents){
        this.islandResidents=islandResidents;
    }
    @Override
    public void run() {
        for (int i = 0; i < islandResidents.length; i++) {
            for (int j = 0; j < islandResidents[i].length; j++) {
                

            }
        }
    }
}
