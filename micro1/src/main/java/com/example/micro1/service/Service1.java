package com.example.micro1.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.micro1.model.People;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Service1", description="Example of service")
public interface Service1 {
	
	@Operation(description = "Return Node Number",  responses = {
			@ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "404", description = "Node number not found!") })
    public int getNodeNumber();    
	
	//@ApiOperation(value = "return version number", nickname = "getVersion", notes = "", response = Integer.class, tags = {"Micro1"})
    public String getVersion();    
	
	//@ApiOperation(value = "return who am I", nickname = "whoAmI", notes = "", response = String.class, tags = {"Micro1"})
	public String whoAmI();

	@Operation(description = "Find person by first name", responses = {
			@ApiResponse(content = @Content(schema = @Schema(implementation = People.class)), responseCode = "200"),
			@ApiResponse(responseCode = "404", description = "Person with such FirstName doesn't exists") })
	public People getPeople(
			@Parameter(description = "FirstName's people to lookup for", required = true) @PathVariable("firstName") final String firstName);

}

