package br.com.safegarage.customer_bff.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={ "Customer Api"})
@RequestMapping("/customers")
public class CustomerBFFController {



}
