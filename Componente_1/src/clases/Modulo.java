
package clases;

public class Modulo {
    String siglasCiclo;
    String siglasModulo;
    String nombreModulo;
    int horasSemanales;

    public Modulo(String siglasCiclo, String siglasModulo, String nombreModulo, int horasSemanales) {
        this.siglasCiclo = siglasCiclo;
        this.siglasModulo = siglasModulo;
        this.nombreModulo = nombreModulo;
        this.horasSemanales = horasSemanales;
    }

    public String getSiglasCiclo() {
        return siglasCiclo;
    }

    public void setSiglasCiclo(String siglasCiclo) {
        this.siglasCiclo = siglasCiclo;
    }

    public String getSiglasModulo() {
        return siglasModulo;
    }

    public void setSiglasModulo(String siglasModulo) {
        this.siglasModulo = siglasModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    @Override
    public String toString() {
        return "Modulo{" + "siglasCiclo=" + siglasCiclo + ", siglasModulo=" + siglasModulo + ", nombreModulo=" + nombreModulo + ", horasSemanales=" + horasSemanales + '}';
    }
        
}
