
package net.idtoki.serteca.model;


import net.zylk.tools.format.FormatUtils;

import org.apache.torque.om.Persistent;

/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Tue May 16 09:57:47 CEST 2006]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class FormaPago
    extends net.idtoki.serteca.model.BaseFormaPago
    implements Persistent
{
	public String getNombreFormaPagoParsed()
	{
		return FormatUtils.genericParsedStr(this.getNombre()) ;
	}
}
