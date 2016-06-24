package net.idtoki.serteca.helper;

import net.zylk.web.WebUtils;
import net.zylk.web.helper.BaseHelper;
import javax.servlet.http.HttpServletRequest;
import org.apache.torque.TorqueException;
import net.zylk.tools.format.FormatUtils;


import net.idtoki.serteca.model.MarcaPeer;
import net.idtoki.serteca.model.Marca;
import net.idtoki.serteca.manager.MarcaManager;

/**
 * This class was autogenerated by Torque on:
 *
 * [Mon Jul 03 11:03:24 CEST 2006]
 *
 */
public abstract class BaseMarcaHelper extends BaseHelper
{
	public static final String COMPLEX_ID_GET_METHOD = "getComplexId";
	private Marca obj;
	public static final String ID_GET_METHOD_NAME = "getId";
	public static final String NOMBRE_GET_METHOD_NAME = "getNombre";


	public BaseMarcaHelper()
	{
		this.obj = new Marca();
	}

	public BaseMarcaHelper(Marca obj)
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

	private static String getIdId(Marca o)
	{
		return MarcaPeer.ID;
	}

	public String getIdName()
	{
		return getIdName(obj);
	}

	private static String getIdName(Marca o)
	{
		return MarcaPeer.ID;
	}

	public String getIdValue()
	{
		return getIdValue(obj);
	}

	private static String getIdValue(Marca o)
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

	private static String getNombreId(Marca o)
	{
		return MarcaPeer.NOMBRE;
	}

	public String getNombreName()
	{
		return getNombreName(obj);
	}

	private static String getNombreName(Marca o)
	{
		return MarcaPeer.NOMBRE;
	}

	public String getNombreValue()
	{
		return getNombreValue(obj);
	}

	private static String getNombreValue(Marca o)
	{
			if(o.getNombre() != null)
			return "" + o.getNombre();
		else
			return "";
		}

	public static Marca getMarca(HttpServletRequest req) throws TorqueException
	{
										
		int id_Id = WebUtils.getintParam(req, getIdName(new Marca()));

	
		Marca o = new Marca();
		if((id_Id >= 0)) // no es nuevo y lo fijamos en el objeto
		{
			o = MarcaManager.getMarca(id_Id);
		}
		return o;
	}

	public static Marca createObj(HttpServletRequest req) throws TorqueException
	{
		Marca o =  BaseMarcaHelper.getMarca(req);
			 o.setId(WebUtils.getintParam(req, getIdName(o)));
		
			 o.setNombre(WebUtils.getStringParam(req, getNombreName(o)));
		
			return o;
	}
}
