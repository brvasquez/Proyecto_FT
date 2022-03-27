package model;

import java.io.InputStream;

public class PdfVO {

    //Todo los atributos/
    int codigopdf;
    String nombrepdf;
    InputStream archivopdf;
    String descripcion;
    private byte[] archivopdf2;

    public PdfVO(int id, String name, byte[] archivo) {
        this.codigopdf = id;
        this.nombrepdf = name;
        this.archivopdf2 = archivo;
        this.descripcion=descripcion;
    }

    public PdfVO() {
    }

    //Todo los codigos get/
    public int getCodigopdf() {
        return codigopdf;
    }

    public String getNombrepdf() {
        return nombrepdf;
    }

    public InputStream getArchivopdf() {
        return archivopdf;
    }

    public String getdescripcion() {
        return nombrepdf;
    }

    //Todo los codigos set/
    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public void setNombrepdf(String nombrepdf) {
        this.nombrepdf = nombrepdf;
    }

    public void setArchivopdf(InputStream archivopdf) {
        this.archivopdf = archivopdf;
    }

    public void setdescripcion(String descripcion) {
        this.nombrepdf = nombrepdf;
    }
    /**
     * @return the archivopdf2
     */
    public byte[] getArchivopdf2() {
        return archivopdf2;
    }

    /**
     * @param archivopdf2 the archivopdf2 to set
     */
    public void setArchivopdf2(byte[] archivopdf2) {
        this.archivopdf2 = archivopdf2;
    }

}