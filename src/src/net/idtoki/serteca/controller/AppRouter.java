package net.idtoki.serteca.controller;

import java.util.logging.Logger;

import javax.servlet.FilterConfig;

import net.zylk.web.controller.BaseRouter;


/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Wed Feb 01 12:46:43 CET 2006]
 *
 *  You should add additional methods to this class to meet the
 *  application requirements.  This class will only be generated as
 *  long as it does not already exist in the output directory.
 */
public class AppRouter extends BaseRouter
{
 private static final Logger logger = Logger.getLogger("net.idtoki.serteca.controller.AppRouter");

 public void init(FilterConfig fc)
 {
  //Aqui hay que cargar la tabla de rutas especiales, ... si las hay
  super.init(fc);
 }
}