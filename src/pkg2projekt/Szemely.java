
package pkg2projekt;

class Szemely {
  
    private String nev;
    private int kor;
    private String cim;
    private int fizetes;
    

    public Szemely(String sor) {
        sor = sor.replace(',', '.');
        String[] s = sor.split(";");
        this.nev = s[0];
        this.kor = Integer.parseInt(s[1]);
        this.cim = s[2];
        this.fizetes = Integer.parseInt(s[3]);
    }

    public Szemely(String nev, int kor, String cim, int fizetes) {
        this.nev = nev;
        this.kor = kor;
        this.cim = cim;
        this.fizetes = fizetes;
    }

    
    
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public int getFizetes() {
        return fizetes;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }

    @Override
    public String toString() {
        return "Adat{" + "nev=" + nev + ", kor=" + kor + ", cim=" + cim + ", fizetes=" + fizetes + '}';
    }
    
    
    
}
