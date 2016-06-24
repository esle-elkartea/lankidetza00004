
package net.idtoki.serteca.model;


import java.util.logging.Logger;

import net.zylk.tools.format.FormatUtils;

import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;

/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Wed Feb 01 12:46:43 CET 2006]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class LineaFactura
    extends net.idtoki.serteca.model.BaseLineaFactura
    implements Persistent
{
	private static final Logger logger = Logger.getLogger("net.idtoki.serteca.controller.LineaFactura");
	
	public String getFacturaIdLineaFacturaParsed()
	{
		String nombre=null;
		try
		{
			 nombre= this.getFacturas().getId() + "-" + this.getFacturas().getReparacionIdFacturasParsed();	
		}
		catch(TorqueException te)
		{
			logger.severe("No se ha podido localizar la factura. public String getClienteIdLineaFacturaParsed()" );
			te.printStackTrace();
		}
		return FormatUtils.genericParsedStr(nombre);
	}
	public String getObsLineaFacturaParsed()
	{
		return FormatUtils.genericParsedStr(this.getObs());
	}
	public String getImporteLineaFacturaParsed()
	{
		return FormatUtils.genericParsedStr(new Float(this.getImporte()).toString());
	}
	public String getUnidadesLineaFacturaParsed()
	{
		return FormatUtils.genericParsedStr(new Float(this.getUnidades()).toString());
	}
	public double getImporteTotalLineaFactura()
	{
		return this.getImporte()*this.getUnidades();
	}	
	public double getImporteTotalConDtoLineaFactura()
	{
		return this.getImporteTotalLineaFactura()-(this.getDto()*this.getImporteTotalLineaFactura()/100);
	}	
	public String getDtoLineaFacturaParsed()
	{
		return FormatUtils.genericParsedStr(new Float(this.getDto()).toString());
	}	
	public String getDescripcionLineaFacturaParsed()
	{
		return FormatUtils.genericParsedStr(this.getDescripcion());
	}	
	public String getDeleteLineaFactura()
	{
		return "<a href='#' class='eliminar' id='getDeleteLineaFactura" + this.getId() + "'>&#160;&#160;&#160;&#160;</a>";
	}	
	public String getEditLineaFactura()
	{
		return "<a href='#' class='edicion' id='getEditLineaFactura" + this.getId() + "'>&#160;&#160;&#160;&#160;</a>";
	}	
}