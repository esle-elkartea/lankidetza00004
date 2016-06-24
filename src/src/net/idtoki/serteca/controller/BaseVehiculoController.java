package net.idtoki.serteca.controller;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.zylk.tools.format.FormatUtils;
import net.zylk.web.WebUtils;
import java.util.ArrayList;
import net.zylk.tools.ajax.AjaxUtils;

import net.idtoki.serteca.manager.VehiculoManager;
import net.idtoki.serteca.helper.VehiculoHelper;

/**
 * This class was autogenerated by Torque on:
 *
 * [Mon Jul 03 11:03:24 CEST 2006]
 *
 */
public abstract class BaseVehiculoController extends AppController
{
 private static final Logger logger = Logger.getLogger("net.idtoki.serteca.controller.BaseVehiculoController");
 protected static final String UPDATE_PRIMARY_KEY_FORM_NAME = "primaryKeyId";
 protected static final String UPDATE_VALUE_FORM_NAME = "value";


        	
  	            
 public void serviceUpdateId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateId(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateIdRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateIdResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateIdResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(Integer.toString(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getId()));
   }

 protected String updateIdRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateModeloId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateModeloId(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateModeloIdRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateModeloIdResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateModeloIdResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(Integer.toString(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getModeloId()));
   }

 protected String updateModeloIdRequestCallBack(String value)
 {
  return FormatUtils.getFkIdFromString(value);
  }
 public void serviceUpdateVersion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateVersion(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateVersionRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateVersionResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateVersionResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getVersion());
   }

 protected String updateVersionRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateMatricula(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateMatricula(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateMatriculaRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateMatriculaResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateMatriculaResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getMatricula());
   }

 protected String updateMatriculaRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateClienteId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateClienteId(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateClienteIdRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateClienteIdResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateClienteIdResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(Integer.toString(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getClienteId()));
   }

 protected String updateClienteIdRequestCallBack(String value)
 {
  return FormatUtils.getFkIdFromString(value);
  }
 public void serviceUpdateChasisId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateChasisId(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateChasisIdRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateChasisIdResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateChasisIdResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getChasisId());
   }

 protected String updateChasisIdRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateMotorId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateMotorId(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateMotorIdRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateMotorIdResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateMotorIdResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getMotorId());
   }

 protected String updateMotorIdRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateColor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateColor(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateColorRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateColorResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateColorResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getColor());
   }

 protected String updateColorRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateFechaMatriculacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateFechaMatriculacion(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateFechaMatriculacionRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateFechaMatriculacionResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateFechaMatriculacionResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getFechaMatriculacion());
   }

 protected String updateFechaMatriculacionRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateFechaRevision(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateFechaRevision(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateFechaRevisionRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateFechaRevisionResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateFechaRevisionResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getFechaRevision());
   }

 protected String updateFechaRevisionRequestCallBack(String value)
 {
  return value;
  }
 public void serviceUpdateObs(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ACTUALIZAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  logger.finest("Nombre A ACTUALIZAR: "+WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.updateObs(
     					   Integer.parseInt(a.get(0).toString()),
   					 updateObsRequestCallBack(WebUtils.getStringParam(request, UPDATE_VALUE_FORM_NAME))
   					);
  				simpleResponseService(response, updateObsResponseCallBack(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME)));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido actualizar el valor"+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 protected StringBuffer updateObsResponseCallBack(String s)
 {
  ArrayList a = AjaxUtils.splitIdFields(s);
    	return new StringBuffer(VehiculoManager.getVehiculo(  Integer.parseInt(a.get(0).toString())).getObs());
   }

 protected String updateObsRequestCallBack(String value)
 {
  return value;
  }

 public void serviceDeleteVehiculo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  logger.finest("ID A ELIMINAR: "+WebUtils.getintParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
  try
  {
   ArrayList a = AjaxUtils.splitIdFields(WebUtils.getStringParam(request, UPDATE_PRIMARY_KEY_FORM_NAME));
   VehiculoManager.deleteVehiculo(  Integer.parseInt(a.get(0).toString()));
  }
  catch (Exception e)
  {
   logger.severe("NO se ha podido eliminar el valor "+ e.getMessage());
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }

 public void serviceAddUpdateVehiculo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
  utf8RequestService(request);
  try
  {
   VehiculoManager.addUpdateVehiculo(VehiculoHelper.createObj(request));
  }
   catch(Exception e)
  {
   response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }
 }


}
