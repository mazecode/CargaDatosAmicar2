package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractCorreoserrorformato entity provides the base persistence definition
 * of the Correoserrorformato entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractCorreoserrorformato implements
		java.io.Serializable {

	// Fields

	private Integer idCliente;
	private String rutCliente;
	private String emailCliente;
	private String nombreCliente;
	private String sexoCliente;
	private String fonoCliente;
	private String automovilCliente;
	private Integer idGrupo;
	private Integer idBody;
	private Timestamp fecha;

	// Constructors

	/** default constructor */
	public AbstractCorreoserrorformato() {
	}

	/** full constructor */
	public AbstractCorreoserrorformato(String rutCliente, String emailCliente,
			String nombreCliente, String sexoCliente, String fonoCliente,
			String automovilCliente, Integer idGrupo, Integer idBody,
			Timestamp fecha) {
		this.rutCliente = rutCliente;
		this.emailCliente = emailCliente;
		this.nombreCliente = nombreCliente;
		this.sexoCliente = sexoCliente;
		this.fonoCliente = fonoCliente;
		this.automovilCliente = automovilCliente;
		this.idGrupo = idGrupo;
		this.idBody = idBody;
		this.fecha = fecha;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCliente", unique = true, nullable = false)
	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "rutCliente", length = 12)
	public String getRutCliente() {
		return this.rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	@Column(name = "emailCliente", length = 45)
	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Column(name = "nombreCliente", length = 45)
	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@Column(name = "sexoCliente", length = 2)
	public String getSexoCliente() {
		return this.sexoCliente;
	}

	public void setSexoCliente(String sexoCliente) {
		this.sexoCliente = sexoCliente;
	}

	@Column(name = "fonoCliente", length = 45)
	public String getFonoCliente() {
		return this.fonoCliente;
	}

	public void setFonoCliente(String fonoCliente) {
		this.fonoCliente = fonoCliente;
	}

	@Column(name = "automovilCliente", length = 45)
	public String getAutomovilCliente() {
		return this.automovilCliente;
	}

	public void setAutomovilCliente(String automovilCliente) {
		this.automovilCliente = automovilCliente;
	}

	@Column(name = "idGrupo")
	public Integer getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	@Column(name = "idBody")
	public Integer getIdBody() {
		return this.idBody;
	}

	public void setIdBody(Integer idBody) {
		this.idBody = idBody;
	}

	@Column(name = "fecha", length = 19)
	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}