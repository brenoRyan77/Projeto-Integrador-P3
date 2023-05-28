package br.com.uniesp.rest;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@OpenAPIDefinition(info = @Info(title = "Projeto Integrador API", version = "1.0.0"))
public class ProjetoIntegradorAPI extends Application{

}
