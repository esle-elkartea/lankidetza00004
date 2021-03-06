package net.idtoki.serteca.manager;

import java.util.logging.Logger;
import net.idtoki.serteca.model.FormaPagoPeer;
import net.idtoki.serteca.group.FormaPagoGroupBean;
import net.idtoki.serteca.model.FormaPago;
import net.zylk.torque.SearchQuery;
import net.zylk.torque.BaseQuery;
import net.zylk.torque.TorqueUtils;
import net.zylk.torque.manager.BaseManager;
import org.apache.torque.TorqueException;
import java.util.Enumeration;



import org.apache.torque.util.Criteria;
import org.apache.torque.util.UniqueList;
import net.zylk.tools.ajax.AjaxUtils.DinamicGridBean;

/**
 * This class was autogenerated by Torque on:
 *
 * [Mon Jul 03 11:03:24 CEST 2006]
 *
 */
public abstract class BaseFormaPagoManager extends BaseManager
{
	protected static final Logger logger = Logger.getLogger(
	   "net.idtoki.serteca.managers.BaseFormaPagoManager");

	public static final Criteria buildSearchCriteria(DinamicGridBean dgb)
	{
		return BaseManager.buildSearchCriteria(dgb, new FormaPagoManager());
	}

	public static final Criteria buildSearchCriteria(String query, int offset, int limit)
	{
		return BaseManager.buildSearchCriteria(query, offset, limit, new FormaPagoManager());
	}

	public static final Criteria buildSearchCriteria(String query)
	{
		return BaseManager.buildSearchCriteria(query, new FormaPagoManager());
	}

	protected void addOrSearchCriteria(Criteria criteria,String campo,String valor, String condicion){
		Criteria.Criterion criterion = FormaPagoManager.getSearchCriterion(campo,valor, condicion);
		//Si existe ya un criterion hay que utilizarlo para añadir el or sino utilizará un and
		Enumeration enumeration =criteria.elements();
		if(enumeration.hasMoreElements()){
			Criteria.Criterion cr = (Criteria.Criterion) enumeration.nextElement();
			cr.or(criterion);
		}else{
			criteria.or(criterion);
		}
	}

	protected void addAndSearchCriteria(Criteria criteria,String campo, String valor, String condicion){
		Criteria.Criterion criterion = FormaPagoManager.getSearchCriterion(campo,valor, condicion);
		criteria.and(criterion);
	}

	protected static Criteria.Criterion getSearchCriterion(String campo,String valor, String condicion){
        Criteria criteria =  new Criteria();
        Criteria.Criterion criterion = null;

			if(campo.equals("all") || campo.equals(BaseManager.campoToLowerCase(FormaPagoPeer.ID)))
		{
			if(condicion.equals(BaseQuery.SingleQuery.EQUAL_CONDITION))
				criterion = TorqueUtils.addOrEqualCriteria(criterion,FormaPagoPeer.ID,valor,true);
			else if (condicion.equals(BaseQuery.SingleQuery.LIKE_CONDITION))
				criterion = TorqueUtils.addOrLikeCriteria(criterion,FormaPagoPeer.ID,valor,true);
			else if (condicion.equals(BaseQuery.SingleQuery.LESS_CONDITION))
				criterion = TorqueUtils.addOrLessCriteria(criterion,FormaPagoPeer.ID,valor,true);
			else if (condicion.equals(BaseQuery.SingleQuery.GREATER_CONDITION))
				criterion = TorqueUtils.addOrGreaterCriteria(criterion,FormaPagoPeer.ID,valor,true);
		}
			if(campo.equals("all") || campo.equals(BaseManager.campoToLowerCase(FormaPagoPeer.NOMBRE)))
		{
			if(condicion.equals(BaseQuery.SingleQuery.EQUAL_CONDITION))
				criterion = TorqueUtils.addOrEqualCriteria(criterion,FormaPagoPeer.NOMBRE,valor,true);
			else if (condicion.equals(BaseQuery.SingleQuery.LIKE_CONDITION))
				criterion = TorqueUtils.addOrLikeCriteria(criterion,FormaPagoPeer.NOMBRE,valor,true);
			else if (condicion.equals(BaseQuery.SingleQuery.LESS_CONDITION))
				criterion = TorqueUtils.addOrLessCriteria(criterion,FormaPagoPeer.NOMBRE,valor,true);
			else if (condicion.equals(BaseQuery.SingleQuery.GREATER_CONDITION))
				criterion = TorqueUtils.addOrGreaterCriteria(criterion,FormaPagoPeer.NOMBRE,valor,true);
		}
		
		return criterion;
	}

	public static final FormaPagoGroupBean getFormaPagos() {
    	return BaseFormaPagoManager.getFormaPagos(false);
	}

	public static final FormaPagoGroupBean getFormaPagos(boolean paginado) {
    	return BaseFormaPagoManager.getFormaPagos(new Criteria(), paginado,0);
	}

	public static final FormaPagoGroupBean getFormaPagos(Criteria c) {
		return BaseFormaPagoManager.getFormaPagos(c,false,0);
	}

	public static final FormaPagoGroupBean getFormaPagos(Criteria criteria,boolean paginado, int pagina) {
		FormaPagoGroupBean objFormaPagoGroupBean = new FormaPagoGroupBean();
		objFormaPagoGroupBean.setPaginaActual(pagina);
		objFormaPagoGroupBean.setFormaPagos(criteria, paginado);
		return objFormaPagoGroupBean;
	}

							
	public static final FormaPago getFormaPago(int id_Id) {
		Criteria c = new Criteria();
			c.add(FormaPagoPeer.ID, id_Id);
			return BaseFormaPagoManager.FormaPagosGroupBean2FormaPago(BaseFormaPagoManager.getFormaPagos(c));
	}

	public static final FormaPago FormaPagosGroupBean2FormaPago(FormaPagoGroupBean obj){
		if(obj.size() == 1)
			return obj.getFormaPago(0);
		else
			return null;
	}

	private static void updateFormaPagoAttribute(int id_Id, String valor, String campo) throws Exception
	{
		FormaPago obj = BaseFormaPagoManager.getFormaPago(id_Id);
			if(campo.equals(FormaPagoPeer.ID))
					obj.setId(Integer.parseInt(valor)); //int
					if(campo.equals(FormaPagoPeer.NOMBRE))
					obj.setNombre(valor); //String
					obj.save();
	}

	public static void updateId(int id_Id, String valor) throws Exception
	{
		updateFormaPagoAttribute(id_Id, valor, FormaPagoPeer.ID);
	}
	public static void updateNombre(int id_Id, String valor) throws Exception
	{
		updateFormaPagoAttribute(id_Id, valor, FormaPagoPeer.NOMBRE);
	}

			public void addJoins(Criteria criteria)
	{
	 //no tiene claves externas asi que el metodo no hace nada
	}
	

  public static void deleteFormaPago(int id_Id) throws TorqueException
  {
  	FormaPagoPeer.doDelete(FormaPagoManager.getFormaPago(id_Id));
  }

  public static FormaPago addUpdateFormaPago(FormaPago obj) throws TorqueException
  {
	FormaPagoGroupBean gb = new FormaPagoGroupBean();
	gb.setElemento(obj);
	gb.save();
	return obj;
  }

}

