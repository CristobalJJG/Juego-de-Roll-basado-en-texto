package text_based_rollgame.Player;

public class HealthPotion {
    
    private int healStat;
    private int nPotion;
    
    protected HealthPotion(){
        this.healStat = 50;
        this.nPotion = 3;
    }
    
    public void addNumberOfPotions(int n){
        this.nPotion += n;
    }
    
    public void setHealStat(int n){
        this.healStat = n;
    }

    public int getHealStat() {
        return healStat;
    }

    public int getNumberOfPotions() {
        return nPotion;
    }

    public void setNumberOfPotion(int nPotion) {
        this.nPotion = nPotion;
    }
}
