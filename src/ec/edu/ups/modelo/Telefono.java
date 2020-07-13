package ec.edu.ups.modelo;
public class Telefono implements Comparable<Telefono>{
    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;
    private Usuario usuario;

    public Telefono() {
    }

    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.codigo = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.operadora = operadora;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the operadora
     */
    public String getOperadora() {
        return operadora;
    }

    /**
     * @param operadora the operadora to set
     */
    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
	if (!this.numero.equalsIgnoreCase(other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Teléfono:\n" + 
                "Código: " + codigo + "\n" + 
                "Número: " + numero + "\n" +
                "Tipo: " + tipo + "\n" +
                "Operadora: " + operadora + "\n";
    }
    
    public String toStringVentana() {
        return "Código: " + codigo + ", " + 
                "Número: " + numero + ", " +
                "Tipo: " + tipo + ", " +
                "Operadora: " + operadora;
    }

    @Override
    public int compareTo(Telefono t) {
	if (this.numero.equalsIgnoreCase(t.numero)) {
            return 0;
        }
	return 1;
    }
}
