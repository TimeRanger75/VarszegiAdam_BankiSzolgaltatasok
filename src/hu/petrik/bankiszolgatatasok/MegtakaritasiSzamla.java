package hu.petrik.bankiszolgatatasok;

public class MegtakaritasiSzamla extends Szamla{
    private double kamat;
    public double alapkamat;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.alapkamat=1.1;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (aktualisEgyenleg-osszeg<0){
            return false;
        }
        else{
            aktualisEgyenleg-=osszeg;
            return true;
        }
    }

    public void kamatJovairas(){
        aktualisEgyenleg*=alapkamat;
    }
}
