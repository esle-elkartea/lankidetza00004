package net.idtoki.serteca.helper;

import net.zylk.web.WebUtils;
import net.zylk.web.helper.BaseHelper;
import javax.servlet.http.HttpServletRequest;
import org.apache.torque.TorqueException;
import net.zylk.tools.format.FormatUtils;


import net.idtoki.serteca.model.ClientePeer;
import net.idtoki.serteca.model.Cliente;
import net.idtoki.serteca.manager.ClienteManager;

/**
 * This class was autogenerated by Torque on:
 *
 * [Mon Jul 03 11:03:24 CEST 2006]
 *
 */
public abstract class BaseClienteHelper extends BaseHelper
{
	public static final String COMPLEX_ID_GET_METHOD = "getComplexId";
	private Cliente obj;
	public static final String ID_GET_METHOD_NAME = "getId";
	public static final String NOMBRE_GET_METHOD_NAME = "getNombre";
	public static final String NOMBRECOMERCIAL_GET_METHOD_NAME = "getNombreComercial";
	public static final String RAZONSOCIAL_GET_METHOD_NAME = "getRazonSocial";
	public static final String NIF_GET_METHOD_NAME = "getNif";
	public static final String DIRECCION_GET_METHOD_NAME = "getDireccion";
	public static final String LOCALIDAD_ID_GET_METHOD_NAME = "getLocalidadId";
	public static final String CP_GET_METHOD_NAME = "getCp";
	public static final String TELEFONO_GET_METHOD_NAME = "getTlfno";
	public static final String MOVIL_GET_METHOD_NAME = "getMovil";
	public static final String FAX_GET_METHOD_NAME = "getFax";
	public static final String EMAIL_GET_METHOD_NAME = "getEmail";
	public static final String FORMA_PAGO_ID_GET_METHOD_NAME = "getFormaPagoId";
	public static final String NUMERO_CUENTA_GET_METHOD_NAME = "getNumeroCuenta";
	public static final String DTO_PRONTO_PAGO_GET_METHOD_NAME = "getDtoProntoPago";
	public static final String DIA_PAGO_GET_METHOD_NAME = "getDiaPago";
	public static final String OBSERVACION_GET_METHOD_NAME = "getObs";


	public BaseClienteHelper()
	{
		this.obj = new Cliente();
	}

	public BaseClienteHelper(Cliente obj)
	{
		this.obj = obj;
	}


	public String getIdHTMLAttrs()
	{
		return " name=\"" + getIdName() + "\" " +
			   "id=\"" + getIdId() + "\" " +
			   "value=\"" + getIdValue() + "\" ";
	 }

	public String getIdId()
	{
		return getIdId(obj);
	}

	private static String getIdId(Cliente o)
	{
		return ClientePeer.ID;
	}

	public String getIdName()
	{
		return getIdName(obj);
	}

	private static String getIdName(Cliente o)
	{
		return ClientePeer.ID;
	}

	public String getIdValue()
	{
		return getIdValue(obj);
	}

	private static String getIdValue(Cliente o)
	{
			return "" + o.getId();
		}

	public String getNombreHTMLAttrs()
	{
		return " name=\"" + getNombreName() + "\" " +
			   "id=\"" + getNombreId() + "\" " +
			   "value=\"" + getNombreValue() + "\" ";
	 }

	public String getNombreId()
	{
		return getNombreId(obj);
	}

	private static String getNombreId(Cliente o)
	{
		return ClientePeer.NOMBRE;
	}

	public String getNombreName()
	{
		return getNombreName(obj);
	}

	private static String getNombreName(Cliente o)
	{
		return ClientePeer.NOMBRE;
	}

	public String getNombreValue()
	{
		return getNombreValue(obj);
	}

	private static String getNombreValue(Cliente o)
	{
			if(o.getNombre() != null)
			return "" + o.getNombre();
		else
			return "";
		}

	public String getNombreComercialHTMLAttrs()
	{
		return " name=\"" + getNombreComercialName() + "\" " +
			   "id=\"" + getNombreComercialId() + "\" " +
			   "value=\"" + getNombreComercialValue() + "\" ";
	 }

	public String getNombreComercialId()
	{
		return getNombreComercialId(obj);
	}

	private static String getNombreComercialId(Cliente o)
	{
		return ClientePeer.NOMBRECOMERCIAL;
	}

	public String getNombreComercialName()
	{
		return getNombreComercialName(obj);
	}

	private static String getNombreComercialName(Cliente o)
	{
		return ClientePeer.NOMBRECOMERCIAL;
	}

	public String getNombreComercialValue()
	{
		return getNombreComercialValue(obj);
	}

	private static String getNombreComercialValue(Cliente o)
	{
			if(o.getNombreComercial() != null)
			return "" + o.getNombreComercial();
		else
			return "";
		}

	public String getRazonSocialHTMLAttrs()
	{
		return " name=\"" + getRazonSocialName() + "\" " +
			   "id=\"" + getRazonSocialId() + "\" " +
			   "value=\"" + getRazonSocialValue() + "\" ";
	 }

	public String getRazonSocialId()
	{
		return getRazonSocialId(obj);
	}

	private static String getRazonSocialId(Cliente o)
	{
		return ClientePeer.RAZONSOCIAL;
	}

	public String getRazonSocialName()
	{
		return getRazonSocialName(obj);
	}

	private static String getRazonSocialName(Cliente o)
	{
		return ClientePeer.RAZONSOCIAL;
	}

	public String getRazonSocialValue()
	{
		return getRazonSocialValue(obj);
	}

	private static String getRazonSocialValue(Cliente o)
	{
			if(o.getRazonSocial() != null)
			return "" + o.getRazonSocial();
		else
			return "";
		}

	public String getNifHTMLAttrs()
	{
		return " name=\"" + getNifName() + "\" " +
			   "id=\"" + getNifId() + "\" " +
			   "value=\"" + getNifValue() + "\" ";
	 }

	public String getNifId()
	{
		return getNifId(obj);
	}

	private static String getNifId(Cliente o)
	{
		return ClientePeer.NIF;
	}

	public String getNifName()
	{
		return getNifName(obj);
	}

	private static String getNifName(Cliente o)
	{
		return ClientePeer.NIF;
	}

	public String getNifValue()
	{
		return getNifValue(obj);
	}

	private static String getNifValue(Cliente o)
	{
			if(o.getNif() != null)
			return "" + o.getNif();
		else
			return "";
		}

	public String getDireccionHTMLAttrs()
	{
		return " name=\"" + getDireccionName() + "\" " +
			   "id=\"" + getDireccionId() + "\" " +
			   "value=\"" + getDireccionValue() + "\" ";
	 }

	public String getDireccionId()
	{
		return getDireccionId(obj);
	}

	private static String getDireccionId(Cliente o)
	{
		return ClientePeer.DIRECCION;
	}

	public String getDireccionName()
	{
		return getDireccionName(obj);
	}

	private static String getDireccionName(Cliente o)
	{
		return ClientePeer.DIRECCION;
	}

	public String getDireccionValue()
	{
		return getDireccionValue(obj);
	}

	private static String getDireccionValue(Cliente o)
	{
			if(o.getDireccion() != null)
			return "" + o.getDireccion();
		else
			return "";
		}

	public String getLocalidadIdHTMLAttrs()
	{
		return " name=\"" + getLocalidadIdName() + "\" " +
			   "id=\"" + getLocalidadIdId() + "\" " +
			   "value=\"" + getLocalidadIdValue() + "\" ";
	 }

	public String getLocalidadIdId()
	{
		return getLocalidadIdId(obj);
	}

	private static String getLocalidadIdId(Cliente o)
	{
		return ClientePeer.LOCALIDAD_ID;
	}

	public String getLocalidadIdName()
	{
		return getLocalidadIdName(obj);
	}

	private static String getLocalidadIdName(Cliente o)
	{
		return ClientePeer.LOCALIDAD_ID;
	}

	public String getLocalidadIdValue()
	{
		return getLocalidadIdValue(obj);
	}

	private static String getLocalidadIdValue(Cliente o)
	{
			return "" + o.getLocalidadId();
		}

	public String getCpHTMLAttrs()
	{
		return " name=\"" + getCpName() + "\" " +
			   "id=\"" + getCpId() + "\" " +
			   "value=\"" + getCpValue() + "\" ";
	 }

	public String getCpId()
	{
		return getCpId(obj);
	}

	private static String getCpId(Cliente o)
	{
		return ClientePeer.CP;
	}

	public String getCpName()
	{
		return getCpName(obj);
	}

	private static String getCpName(Cliente o)
	{
		return ClientePeer.CP;
	}

	public String getCpValue()
	{
		return getCpValue(obj);
	}

	private static String getCpValue(Cliente o)
	{
			if(o.getCp() != null)
			return "" + o.getCp();
		else
			return "";
		}

	public String getTlfnoHTMLAttrs()
	{
		return " name=\"" + getTlfnoName() + "\" " +
			   "id=\"" + getTlfnoId() + "\" " +
			   "value=\"" + getTlfnoValue() + "\" ";
	 }

	public String getTlfnoId()
	{
		return getTlfnoId(obj);
	}

	private static String getTlfnoId(Cliente o)
	{
		return ClientePeer.TELEFONO;
	}

	public String getTlfnoName()
	{
		return getTlfnoName(obj);
	}

	private static String getTlfnoName(Cliente o)
	{
		return ClientePeer.TELEFONO;
	}

	public String getTlfnoValue()
	{
		return getTlfnoValue(obj);
	}

	private static String getTlfnoValue(Cliente o)
	{
			if(o.getTlfno() != null)
			return "" + o.getTlfno();
		else
			return "";
		}

	public String getMovilHTMLAttrs()
	{
		return " name=\"" + getMovilName() + "\" " +
			   "id=\"" + getMovilId() + "\" " +
			   "value=\"" + getMovilValue() + "\" ";
	 }

	public String getMovilId()
	{
		return getMovilId(obj);
	}

	private static String getMovilId(Cliente o)
	{
		return ClientePeer.MOVIL;
	}

	public String getMovilName()
	{
		return getMovilName(obj);
	}

	private static String getMovilName(Cliente o)
	{
		return ClientePeer.MOVIL;
	}

	public String getMovilValue()
	{
		return getMovilValue(obj);
	}

	private static String getMovilValue(Cliente o)
	{
			if(o.getMovil() != null)
			return "" + o.getMovil();
		else
			return "";
		}

	public String getFaxHTMLAttrs()
	{
		return " name=\"" + getFaxName() + "\" " +
			   "id=\"" + getFaxId() + "\" " +
			   "value=\"" + getFaxValue() + "\" ";
	 }

	public String getFaxId()
	{
		return getFaxId(obj);
	}

	private static String getFaxId(Cliente o)
	{
		return ClientePeer.FAX;
	}

	public String getFaxName()
	{
		return getFaxName(obj);
	}

	private static String getFaxName(Cliente o)
	{
		return ClientePeer.FAX;
	}

	public String getFaxValue()
	{
		return getFaxValue(obj);
	}

	private static String getFaxValue(Cliente o)
	{
			if(o.getFax() != null)
			return "" + o.getFax();
		else
			return "";
		}

	public String getEmailHTMLAttrs()
	{
		return " name=\"" + getEmailName() + "\" " +
			   "id=\"" + getEmailId() + "\" " +
			   "value=\"" + getEmailValue() + "\" ";
	 }

	public String getEmailId()
	{
		return getEmailId(obj);
	}

	private static String getEmailId(Cliente o)
	{
		return ClientePeer.EMAIL;
	}

	public String getEmailName()
	{
		return getEmailName(obj);
	}

	private static String getEmailName(Cliente o)
	{
		return ClientePeer.EMAIL;
	}

	public String getEmailValue()
	{
		return getEmailValue(obj);
	}

	private static String getEmailValue(Cliente o)
	{
			if(o.getEmail() != null)
			return "" + o.getEmail();
		else
			return "";
		}

	public String getFormaPagoIdHTMLAttrs()
	{
		return " name=\"" + getFormaPagoIdName() + "\" " +
			   "id=\"" + getFormaPagoIdId() + "\" " +
			   "value=\"" + getFormaPagoIdValue() + "\" ";
	 }

	public String getFormaPagoIdId()
	{
		return getFormaPagoIdId(obj);
	}

	private static String getFormaPagoIdId(Cliente o)
	{
		return ClientePeer.FORMA_PAGO_ID;
	}

	public String getFormaPagoIdName()
	{
		return getFormaPagoIdName(obj);
	}

	private static String getFormaPagoIdName(Cliente o)
	{
		return ClientePeer.FORMA_PAGO_ID;
	}

	public String getFormaPagoIdValue()
	{
		return getFormaPagoIdValue(obj);
	}

	private static String getFormaPagoIdValue(Cliente o)
	{
			return "" + o.getFormaPagoId();
		}

	public String getNumeroCuentaHTMLAttrs()
	{
		return " name=\"" + getNumeroCuentaName() + "\" " +
			   "id=\"" + getNumeroCuentaId() + "\" " +
			   "value=\"" + getNumeroCuentaValue() + "\" ";
	 }

	public String getNumeroCuentaId()
	{
		return getNumeroCuentaId(obj);
	}

	private static String getNumeroCuentaId(Cliente o)
	{
		return ClientePeer.NUMERO_CUENTA;
	}

	public String getNumeroCuentaName()
	{
		return getNumeroCuentaName(obj);
	}

	private static String getNumeroCuentaName(Cliente o)
	{
		return ClientePeer.NUMERO_CUENTA;
	}

	public String getNumeroCuentaValue()
	{
		return getNumeroCuentaValue(obj);
	}

	private static String getNumeroCuentaValue(Cliente o)
	{
			if(o.getNumeroCuenta() != null)
			return "" + o.getNumeroCuenta();
		else
			return "";
		}

	public String getDtoProntoPagoHTMLAttrs()
	{
		return " name=\"" + getDtoProntoPagoName() + "\" " +
			   "id=\"" + getDtoProntoPagoId() + "\" " +
			   "value=\"" + getDtoProntoPagoValue() + "\" ";
	 }

	public String getDtoProntoPagoId()
	{
		return getDtoProntoPagoId(obj);
	}

	private static String getDtoProntoPagoId(Cliente o)
	{
		return ClientePeer.DTO_PRONTO_PAGO;
	}

	public String getDtoProntoPagoName()
	{
		return getDtoProntoPagoName(obj);
	}

	private static String getDtoProntoPagoName(Cliente o)
	{
		return ClientePeer.DTO_PRONTO_PAGO;
	}

	public String getDtoProntoPagoValue()
	{
		return getDtoProntoPagoValue(obj);
	}

	private static String getDtoProntoPagoValue(Cliente o)
	{
			return "" + o.getDtoProntoPago();
		}

	public String getDiaPagoHTMLAttrs()
	{
		return " name=\"" + getDiaPagoName() + "\" " +
			   "id=\"" + getDiaPagoId() + "\" " +
			   "value=\"" + getDiaPagoValue() + "\" ";
	 }

	public String getDiaPagoId()
	{
		return getDiaPagoId(obj);
	}

	private static String getDiaPagoId(Cliente o)
	{
		return ClientePeer.DIA_PAGO;
	}

	public String getDiaPagoName()
	{
		return getDiaPagoName(obj);
	}

	private static String getDiaPagoName(Cliente o)
	{
		return ClientePeer.DIA_PAGO;
	}

	public String getDiaPagoValue()
	{
		return getDiaPagoValue(obj);
	}

	private static String getDiaPagoValue(Cliente o)
	{
			return "" + o.getDiaPago();
		}

	public String getObsHTMLAttrs()
	{
		return " name=\"" + getObsName() + "\" " +
			   "id=\"" + getObsId() + "\" " +
			   "value=\"" + getObsValue() + "\" ";
	 }

	public String getObsId()
	{
		return getObsId(obj);
	}

	private static String getObsId(Cliente o)
	{
		return ClientePeer.OBSERVACION;
	}

	public String getObsName()
	{
		return getObsName(obj);
	}

	private static String getObsName(Cliente o)
	{
		return ClientePeer.OBSERVACION;
	}

	public String getObsValue()
	{
		return getObsValue(obj);
	}

	private static String getObsValue(Cliente o)
	{
			if(o.getObs() != null)
			return "" + o.getObs();
		else
			return "";
		}

	public static Cliente getCliente(HttpServletRequest req) throws TorqueException
	{
										
		int id_Id = WebUtils.getintParam(req, getIdName(new Cliente()));

	
		Cliente o = new Cliente();
		if((id_Id >= 0)) // no es nuevo y lo fijamos en el objeto
		{
			o = ClienteManager.getCliente(id_Id);
		}
		return o;
	}

	public static Cliente createObj(HttpServletRequest req) throws TorqueException
	{
		Cliente o =  BaseClienteHelper.getCliente(req);
			 o.setId(WebUtils.getintParam(req, getIdName(o)));
		
			 o.setNombre(WebUtils.getStringParam(req, getNombreName(o)));
		
			 o.setNombreComercial(WebUtils.getStringParam(req, getNombreComercialName(o)));
		
			 o.setRazonSocial(WebUtils.getStringParam(req, getRazonSocialName(o)));
		
			 o.setNif(WebUtils.getStringParam(req, getNifName(o)));
		
			 o.setDireccion(WebUtils.getStringParam(req, getDireccionName(o)));
		
			 		o.setLocalidadId(Integer.parseInt(FormatUtils.getFkIdFromString(WebUtils.getStringParam(req, getLocalidadIdName(o)))));
		
			 o.setCp(WebUtils.getStringParam(req, getCpName(o)));
		
			 o.setTlfno(WebUtils.getStringParam(req, getTlfnoName(o)));
		
			 o.setMovil(WebUtils.getStringParam(req, getMovilName(o)));
		
			 o.setFax(WebUtils.getStringParam(req, getFaxName(o)));
		
			 o.setEmail(WebUtils.getStringParam(req, getEmailName(o)));
		
			 		o.setFormaPagoId(Integer.parseInt(FormatUtils.getFkIdFromString(WebUtils.getStringParam(req, getFormaPagoIdName(o)))));
		
			 o.setNumeroCuenta(WebUtils.getStringParam(req, getNumeroCuentaName(o)));
		
			 o.setDtoProntoPago(WebUtils.getintParam(req, getDtoProntoPagoName(o)));
		
			 o.setDiaPago(WebUtils.getintParam(req, getDiaPagoName(o)));
		
			 o.setObs(WebUtils.getStringParam(req, getObsName(o)));
		
			return o;
	}
}