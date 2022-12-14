package hu.petrik.bankiszolgatatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Szamla> szamlaLista;

    public Bank() {
        this.szamlaLista = new ArrayList<>();
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        if (hitelKeret<0){
            HitelSzamla h=new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista.add(h);
            return h;
        } else {
            MegtakaritasiSzamla m_sz= new MegtakaritasiSzamla(tulajdonos);
            szamlaLista.add(m_sz);
            return m_sz;
        }
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos){
        int ossz=0;
        for (Szamla sz :
                szamlaLista) {
            if (sz.getTulajdonos()==tulajdonos){
                ossz+=sz.aktualisEgyenleg;
            }
        }
        return ossz;
    }


    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){
        Szamla m_szamla=null;
        for (int i=0; i< szamlaLista.size();i++){
            if (szamlaLista.get(i).getTulajdonos()==tulajdonos){
                m_szamla=szamlaLista.get(i);
            }
        }
        for (Szamla szamla :
                szamlaLista) {
            if (szamla.getTulajdonos()==tulajdonos && szamla.getAktualisEgyenleg()>m_szamla.getAktualisEgyenleg())
                m_szamla=szamla;
        }
        return m_szamla;
    }

    public long getOsszHitelkeret(){
        long ossz=0;
        for (Szamla szamla :
                szamlaLista) {
            if (szamla instanceof HitelSzamla){
                ossz+=((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return ossz;
    }
}
