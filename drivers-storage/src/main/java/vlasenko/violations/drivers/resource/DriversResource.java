package vlasenko.violations.drivers.resource;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vlasenko.violations.drivers.domain.Driver;
import vlasenko.violations.drivers.exception.DriverNotFoundException;
import vlasenko.violations.drivers.repository.DriversRepository;

import javax.validation.Valid;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DriversResource {

    @Autowired
    private DriversRepository driversRepository;

    @RequestMapping(method = GET)
    public Collection<Driver> getAll() {
        return driversRepository.findAll();
    }

    @ApiOperation(value = "getDriver", nickname = "getDriver")
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "Driver's id", dataType = "long", paramType = "path"))
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Driver.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = GET, path = "/{id}")
    public Driver getDriver(@PathVariable long id) {
        return driversRepository.findById(id).orElseThrow(DriverNotFoundException::new);
    }

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createDriver(@RequestBody @Valid Driver driver) {
        driversRepository.save(driver);
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDriver(@PathVariable long id) {
        driversRepository.delete(id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Driver was not found")
    @ExceptionHandler(value = {DriverNotFoundException.class, EmptyResultDataAccessException.class})
    public void driverNotFound() {
    }
}

