package net.idtoki.serteca.manager;

import net.idtoki.serteca.model.ModeloPeer;
import net.idtoki.serteca.model.VehiculoPeer;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;


/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Wed Feb 01 12:46:43 CET 2006]
 *
 *  You should add additional methods to this class to meet the
 *  application requirements.  This class will only be generated as
 *  long as it does not already exist in the output directory.
 */
public class ModeloManager
    extends BaseModeloManager
{
	public static boolean borraModelo(int idBorrar) {

		Criteria c=new Criteria();
		c.add(ModeloPeer.ID, idBorrar);
		boolean bRet = false;
		try {
			ModeloPeer.doDelete(c);
			bRet = true;
		} catch (TorqueException e) {
			logger.info("No se ha podido borrar el Modelo");
			e.printStackTrace();
			bRet = false;
		}
		return bRet;
	}	
}

