package net.idtoki.serteca.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import net.idtoki.serteca.group.OrdenTrabajoGroupBean;
import net.idtoki.serteca.group.ReparacionGroupBean;
import net.idtoki.serteca.group.TrabajadorGroupBean;
import net.idtoki.serteca.helper.OrdenTrabajoHelper;
import net.idtoki.serteca.helper.ReparacionHelper;
import net.idtoki.serteca.helper.TrabajadorHelper;
import net.idtoki.serteca.manager.OrdenTrabajoManager;
import net.idtoki.serteca.manager.ReparacionManager;
import net.idtoki.serteca.manager.TrabajadorManager;
import net.idtoki.serteca.model.OrdenTrabajo;
import net.idtoki.serteca.model.OrdenTrabajoPeer;
import net.idtoki.serteca.model.ReparacionPeer;
import net.idtoki.serteca.model.TrabajadorPeer;
import net.zylk.tools.ajax.AjaxUtils;
import net.zylk.tools.ajax.AjaxUtils.DinamicGridBean;
import net.zylk.tools.format.FormatUtils;
import net.zylk.tools.pdf.PdfUtils;
import net.zylk.tools.xml.XmlUtils;
import net.zylk.torque.TorqueUtils;
import net.zylk.web.WebUtils;

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
public class OrdenTrabajoController
    extends net.idtoki.serteca.controller.BaseOrdenTrabajoController
{
 private static final Logger logger = Logger.getLogger("net.idtoki.serteca.controller.OrdenTrabajoController");
 private TransformerFactory tFactory = TransformerFactory.newInstance();
 private Transformer orden_trabajo_transformer = null;  
 private Transformer orden_trabajos_transformer = null;  

 public void init(ServletConfig config)
 {
	  super.init();
	  ResourceBundle resource = ResourceBundle.getBundle("net/idtoki/serteca/app/config/app-config");
	  File ordenTrabajo = new File(resource.getString("app.xsl.templates.dir")+"/PdfOrdenTrabajo.xslt");
	  Source xslSource = new StreamSource(ordenTrabajo);
	  File ordenTrabajos = new File(resource.getString("app.xsl.templates.dir")+"/PdfListaOrdenTrabajo.xslt");
	  Source xslSourceT = new StreamSource(ordenTrabajos); 	  
	  try{
		  orden_trabajo_transformer = tFactory.newTransformer(xslSource);
		  orden_trabajos_transformer = tFactory.newTransformer(xslSourceT);
	  }catch (Exception e){
	    e.printStackTrace();
	  }  
 }
 
 public void serviceAddOrdenTrabajo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
		//recojo los parametros del formulario y doy de alta una nueva reparaci�n
	 try
	 {
		 utf8RequestService(request);
		 String tipo =  WebUtils.getStringParam(request, "Ordenes_Trabajo.TIPO");
		 String [] valor= tipo.split("-");		 
		 OrdenTrabajo ot = OrdenTrabajoHelper.createObj(request);
		 ot.setTipo(new Integer(valor[0]).intValue());
		 ot.setFechaEntrada(FormatUtils.ddmmaaaa2aaaammdd(ot.getFechaEntrada(),"-",""));
		 ot.setFechaSalida(FormatUtils.ddmmaaaa2aaaammdd(ot.getFechaSalida(),"-",""));
		 if (ot.getHoras()==-1)
			 ot.setHoras(0);
		 if (ot.getImporte()==-1)
			 ot.setImporte(0);
		 OrdenTrabajoGroupBean otgb = new OrdenTrabajoGroupBean();
		 otgb.setElemento(ot);
		 otgb.save();
	 }
	 catch(TorqueException te)
	 {
		 response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	 }
 }
 
 public void serviceDeleteOrdenTrabajo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
		//recojo los parametros del formulario y doy de alta una nueva reparaci�n
		 int idBorrar=-1;
		 idBorrar=WebUtils.getintParam(request,"borrarId");
		 if (idBorrar!=-1)
			 if (OrdenTrabajoManager.borraOrdenTrabajo(idBorrar))
				 WebUtils.writeXmlResponse(response,XmlUtils.buildXmlOKResponse("ISO-8859-1"));
			 else
				 WebUtils.writeXmlResponse(response,XmlUtils.buildXmlNotOKResponse("ISO-8859-1"));				 
 }
 
 public StringBuffer replaceStringBuffer (StringBuffer strBA, String strOrigen, String strDestino) 
 {
	 return new StringBuffer(strBA.toString().replaceAll(strOrigen,strDestino));
 }
 
 private Criteria ordenacion(Criteria c,String CampoOrdenacion,String OrdenOrdenacion) 
 { 
 	if((OrdenOrdenacion != null )&& (OrdenOrdenacion.compareTo("ASC")==0))
 		if ((CampoOrdenacion != null)) //&& (CampoOrdenacion.compareTo("nombre")==0))
 		{
 			//c.clear();
 			c.addAscendingOrderByColumn(CampoOrdenacion.toString());
 		}
 	if  ((OrdenOrdenacion != null) && (OrdenOrdenacion.compareTo("DESC")==0))
 		if ((CampoOrdenacion != null)) //&& (CampoOrdenacion.compareTo("nombre")==0))
 			{
 			//c.clear();
 			c.addDescendingOrderByColumn(CampoOrdenacion.toString());
 		}
 	return c;
 }

 private Criteria filtro(Criteria c,int filtro) 
 { 
 	 String cadena=null;
	 switch (filtro)
 	 {
	  case 1:
		  //aqu� se filtar�an las que estan en ejecuci�n
		  c.add(OrdenTrabajoPeer.FECHA_SALIDA, (Object) cadena, Criteria.ISNULL);
		  break;
	  case 2:
		  //aqu� se filtar�an las que est�n finalizadas
		  c.add(OrdenTrabajoPeer.FECHA_SALIDA, (Object) cadena, Criteria.ISNOTNULL);
		  break;
	 default:
		 //El caso de querer ver todas
	 	 break;  
 	 }
 	return c;
 }
 private Criteria criteriaOrdenTrabajoTableContent(HttpServletRequest request,Criteria c) throws IOException, ServletException
 {
	 String param =  WebUtils.getStringParam(request, new TrabajadorHelper().getIdName());
	 if(param != null)
		 TorqueUtils.addEqualCriteria(c,OrdenTrabajoPeer.RESPONSABLE_ID, param);	
	 param =  WebUtils.getStringParam(request, new ReparacionHelper().getIdName());
	 if(param != null)
		 TorqueUtils.addEqualCriteria(c,OrdenTrabajoPeer.REPARACION_ID, param);		 
 	  String paramSortCol =  WebUtils.getStringParam(request, "sort_col");
 	  String paramSortDir =  WebUtils.getStringParam(request, "sort_dir");
 	  int paramFiltro =  WebUtils.getintParam(request, "filtro");
 	  c = ordenacion(c,paramSortCol,paramSortDir);
	  c = filtro(c,paramFiltro);
 	  
 	  return c;
 } 
 
 public void serviceOrdenTrabajoTableContent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
	 utf8RequestService(request);
	 int numElemPedidosBD = 40;
	 int gap = 0;//gap = viewedRows - numElemVisiblesUltPag	  
	 DinamicGridBean dgb = WebUtils.getDinamicGridBeanParam(request,numElemPedidosBD,gap);
	 Criteria c =OrdenTrabajoManager.buildSearchCriteria(dgb);
	 c =criteriaOrdenTrabajoTableContent(request,c);

	 OrdenTrabajoGroupBean rgb = OrdenTrabajoManager.getOrdenTrabajos(c);
	 dgb.setTotalSize(rgb.getTotalSize());
	  
	 String[] methodos= new String[] {
			 OrdenTrabajoHelper.REPARACION_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.RESPONSABLE_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",			 
			 OrdenTrabajoHelper.FECHA_ENTRADA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.FECHA_SALIDA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.TIPO_GET_METHOD_NAME + "OrdenTrabajoParsedLabel",
			 OrdenTrabajoHelper.HORAS_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.IMPORTE_GET_METHOD_NAME + "OrdenTrabajoParsed",
//			 OrdenTrabajoHelper.OBSERVACION_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.DESCRIPCION_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 "getEditOrdenTrabajo",
			 "getDeleteOrdenTrabajo"
	 };
	  
	 xmlResponseService(response,AjaxUtils.buildXmlAjaxResponseTableContentFromListObj(
			  										rgb.getAlmacen(),
			  										methodos,
			  										OrdenTrabajoHelper.ID_GET_METHOD_NAME, dgb,"ISO-8859-1")); 
 }
 
 public void serviceTipoOrdenTrabajoUlContent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
	 utf8RequestService(request);
	 String cadena="<ul><li>0-Electricidad</li><li>1-Mecanica</li><li>2-Chapa</li><li>3-Pintura</li><li>4-Neumatica</li></ul>";
	 response.getWriter().print(cadena);
 } 
 
 public void serviceOrdenTrabajoElement(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  StringBuffer cadena=null;
  Criteria c= new Criteria();
  int claveId=-1;
  claveId=WebUtils.getintParam(request, "ordenestrabajo.ID");
  if (claveId!=-1)
  {
	  c.add(OrdenTrabajoPeer.ID, claveId);
  }
  c.addAscendingOrderByColumn(OrdenTrabajoPeer.ID);
  OrdenTrabajoGroupBean trgb = OrdenTrabajoManager.getOrdenTrabajos(c);
  
  if (trgb.getTotalSize()!=0)
  {
	  String [] parametros={
			  	 OrdenTrabajoHelper.ID_GET_METHOD_NAME,
				 OrdenTrabajoHelper.REPARACION_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",
				 OrdenTrabajoHelper.RESPONSABLE_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",			 
				 OrdenTrabajoHelper.FECHA_ENTRADA_GET_METHOD_NAME + "OrdenTrabajoParsed",
				 OrdenTrabajoHelper.FECHA_SALIDA_GET_METHOD_NAME + "OrdenTrabajoParsed",
				 OrdenTrabajoHelper.TIPO_GET_METHOD_NAME + "OrdenTrabajoParsed",
				 OrdenTrabajoHelper.HORAS_GET_METHOD_NAME + "OrdenTrabajoParsed",
				 OrdenTrabajoHelper.IMPORTE_GET_METHOD_NAME + "OrdenTrabajoParsed",
				 OrdenTrabajoHelper.OBSERVACION_GET_METHOD_NAME + "OrdenTrabajoParsed",
				 OrdenTrabajoHelper.DESCRIPCION_GET_METHOD_NAME + "OrdenTrabajoParsed"		  
	  			};
	  cadena=trgb.buildXml(parametros,null,"ISO-8859-1");
  }
  xmlResponseService(response, cadena);
 }  
 
 protected StringBuffer updateReparacionIdResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(OrdenTrabajoManager.getOrdenTrabajo(
    			Integer.parseInt(a.get(0).toString())).getReparacionIdOrdenTrabajoParsed());
 } 
 
 protected StringBuffer updateResponsableIdResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(OrdenTrabajoManager.getOrdenTrabajo(
    			Integer.parseInt(a.get(0).toString())).getResponsableIdOrdenTrabajoParsed());
 }  
 
 protected StringBuffer updateImporteResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(OrdenTrabajoManager.getOrdenTrabajo(
    			Integer.parseInt(a.get(0).toString())).getImporteOrdenTrabajoParsed());
 } 
 
 protected StringBuffer updateHorasResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(OrdenTrabajoManager.getOrdenTrabajo(
    			Integer.parseInt(a.get(0).toString())).getHorasOrdenTrabajoParsed());
 } 
 
 protected StringBuffer updateDescripcionResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(OrdenTrabajoManager.getOrdenTrabajo(
    			Integer.parseInt(a.get(0).toString())).getDescripcionOrdenTrabajoParsed());
 } 

 protected String updateImporteRequestCallBack(String value)
 {
	 String importe="0";
	 if (value.compareTo("")!=0)
		 importe=value;
  return importe;
  }
 
 protected String updateHorasRequestCallBack(String value)
 {
	 String horas="0";
	 if (value.compareTo("")!=0)
		 horas=value;
  return horas;
  }
 
 public void serviceOrdenTrabajoReparacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  String cadena=null;
  Criteria c= new Criteria();
  int claveId=-1;
  claveId=WebUtils.getintParam(request, "Ordenes_Trabajo.TIPO");
  if (claveId!=-1)
  {
	  c.add(OrdenTrabajoPeer.TIPO, claveId);
  }
  c.addAscendingOrderByColumn(OrdenTrabajoPeer.TIPO);
  OrdenTrabajoGroupBean trgb = OrdenTrabajoManager.getOrdenTrabajos(c);
  
  if (trgb.getTotalSize()!=0)
  {
	  cadena = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>";
  	  cadena = cadena + "<result><Ordenes_Trabajo.TIPO>" + trgb.getOrdenTrabajo(0).getTipoOrdenTrabajoParsed() + "</Ordenes_Trabajo.TIPO></result>";
  }
  
  xmlResponseService(response, new StringBuffer(cadena));
 }
 
 public void serviceOrdenTrabajoTrabajador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  String cadena=null;
  Criteria c= new Criteria();
  int claveId=-1;
  claveId=WebUtils.getintParam(request, "Trabajadores.ID");
  if (claveId!=-1)
  {
	  c.add(TrabajadorPeer.ID, claveId);
  }
  c.addAscendingOrderByColumn(TrabajadorPeer.ID);
  TrabajadorGroupBean trgb = TrabajadorManager.getTrabajadors(c);
  
  if (trgb.getTotalSize()!=0)
  {
	  cadena = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>";
  	  cadena = cadena + "<result><Ordenes_Trabajo.RESPONSABLE_ID>" + trgb.getTrabajador(0).getId() + "-" + trgb.getTrabajador(0).getApellidosTrabajadorParsed() + "</Ordenes_Trabajo.RESPONSABLE_ID></result>";
  }
  
  xmlResponseService(response, new StringBuffer(cadena));
 } 
 
 public void serviceTipoOrdenTrabajo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  String cadena=null;
  Criteria c= new Criteria();
  int claveId=-1;
  claveId=WebUtils.getintParam(request, "Trabajadores.ID");
  if (claveId!=-1)
  {
	  c.add(TrabajadorPeer.ID, claveId);
  }
  c.addAscendingOrderByColumn(TrabajadorPeer.ID);
  TrabajadorGroupBean trgb = TrabajadorManager.getTrabajadors(c);
  
  if (trgb.getTotalSize()!=0)
  {
	  cadena = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>";
  	  cadena = cadena + "<result><Ordenes_Trabajo.RESPONSABLE_ID>" + trgb.getTrabajador(0).getId() + "-" + trgb.getTrabajador(0).getApellidosTrabajadorParsed() + "</Ordenes_Trabajo.RESPONSABLE_ID></result>";
  }
  
  xmlResponseService(response, new StringBuffer(cadena));
 } 
 
 public void serviceGetOrdenTrabajoDetalleXml (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
	 utf8RequestService(request);
	 String[] getMethodos= new String[] {
		  	 OrdenTrabajoHelper.ID_GET_METHOD_NAME,
			 OrdenTrabajoHelper.REPARACION_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.RESPONSABLE_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",			 
			 OrdenTrabajoHelper.FECHA_ENTRADA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.FECHA_SALIDA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.TIPO_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.HORAS_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.IMPORTE_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.OBSERVACION_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.DESCRIPCION_GET_METHOD_NAME + "OrdenTrabajoParsed"	
			 };
	  
	 
	 OrdenTrabajoGroupBean tgb = new OrdenTrabajoGroupBean();
	 try
	{
		tgb.setElemento(OrdenTrabajoHelper.getOrdenTrabajo(request));
	} catch (TorqueException e)
	{
		logger.severe(e.getMessage());
	}
	 xmlResponseService(response,tgb.buildXml(getMethodos, null,"ISO-8859-1"));
 }
 
 public void serviceGetOrdenTrabajoDetallePdf(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
	 utf8RequestService(request);
	 String[] getMethodos= new String[] {
		  	 OrdenTrabajoHelper.ID_GET_METHOD_NAME,
			 OrdenTrabajoHelper.REPARACION_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.RESPONSABLE_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",			 
			 OrdenTrabajoHelper.FECHA_ENTRADA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.FECHA_SALIDA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.TIPO_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.HORAS_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.IMPORTE_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.OBSERVACION_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.DESCRIPCION_GET_METHOD_NAME + "OrdenTrabajoParsed"	
			 };
	  
	 
	 OrdenTrabajoGroupBean tgb = new OrdenTrabajoGroupBean();
	 try
	{
		tgb.setElemento(OrdenTrabajoHelper.getOrdenTrabajo(request));
	} catch (TorqueException e)
	{
		logger.severe(e.getMessage());
	}
	
	 byte[] content =  PdfUtils.getBytes(replaceStringBuffer(tgb.buildXml(getMethodos, null,"ISO-8859-1"),"n/a"," "), orden_trabajo_transformer,"ISO-8859-1");
	   response.addHeader("content-disposition","attachment;filename=ordenTrabajoDetalle.pdf");
	   response.setContentType("application/pdf");
	   response.setHeader("Cache-Control", "");//para que funcione en IE
	   response.setContentLength(content.length);
	   response.getOutputStream().write(content);
	   response.getOutputStream().flush();  
	   response.getOutputStream().close();
	
 }  
 
 public void serviceOrdenTrabajoTableContentPdf(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
	 utf8RequestService(request);
  Criteria c= new Criteria();
  String paramQuery =  WebUtils.getStringParam(request, "query");
  if ((paramQuery != null)&& (paramQuery.compareTo("")!=0) )
	  c = OrdenTrabajoManager.buildSearchCriteria(paramQuery);    
  c =criteriaOrdenTrabajoTableContent(request,c);  
  OrdenTrabajoGroupBean tgb = OrdenTrabajoManager.getOrdenTrabajos(c);
  
  String[] methodos= new String[] {	
			 OrdenTrabajoHelper.REPARACION_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.RESPONSABLE_ID_GET_METHOD_NAME + "OrdenTrabajoParsed",			 
			 OrdenTrabajoHelper.FECHA_ENTRADA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.FECHA_SALIDA_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.TIPO_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.HORAS_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.IMPORTE_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.OBSERVACION_GET_METHOD_NAME + "OrdenTrabajoParsed",
			 OrdenTrabajoHelper.DESCRIPCION_GET_METHOD_NAME + "OrdenTrabajoParsed"
			};
  
	 byte[] content =  PdfUtils.getBytes(replaceStringBuffer(tgb.buildXml(methodos, null,"ISO-8859-1"),"n/a"," "), orden_trabajos_transformer,"ISO-8859-1");
	   response.addHeader("content-disposition","attachment;filename=ListaOrdenTrabajo.pdf");
	   response.setContentType("application/pdf");
	   response.setHeader("Cache-Control", "");//para que funcione en IE
	   response.setContentLength(content.length);
	   response.getOutputStream().write(content);
	   response.getOutputStream().flush();  
	   response.getOutputStream().close(); 

 }   
 
}

