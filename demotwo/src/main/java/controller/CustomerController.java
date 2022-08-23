package controller;

import entity.Customer;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.web.bind.annotation.*;
import repository.CustomerRepository;

@RestController
@RequestMapping(path = "/customer")
//public class CustomerController {
//    @PutMapping("{id}")
//    private Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
//        Customer cust = CustomerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer not found");
//        cust.setnameOfCustomer(customer.getNameOfCustomer());
////      dept.setName(department.getName());
//        Customer customer1 = CustomerRepository.<Customer>save(cust);
//        return customer1;
    }

}
