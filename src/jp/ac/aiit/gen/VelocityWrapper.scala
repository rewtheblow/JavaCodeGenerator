package jp.ac.aiit.gen

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;

class VelocityWrapper(templeFileName : String) {

  	private	val engine		= new VelocityEngine()
	private val template	= engine.getTemplate(templeFileName);
	private val context		= new VelocityContext()
	
	def set = {
		val props		= new Properties()
//		engine.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogSystem")
		engine.init(props)
	}
	
	def put(key: String, value: Any) {
		context.put(key, value)
	}
	
	def merge() = {
		val sw		= new StringWriter()
		template.merge(context, sw)
		sw.toString()
	}
}