package onegroup.onekids_excel_v3.service.filter;

import onegroup.onekids_excel_v3.dto.filter.OrderKidsExcelDTO;
import onegroup.onekids_excel_v3.entity.excel.*;
import onegroup.onekids_excel_v3.repository.filter.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderKidsExcelService {
    @Autowired
    IOrderKidsExcelT01Repo iOrderKidsExcelT01Repo;
    @Autowired
    IOrderKidsExcelT02Repo iOrderKidsExcelT02Repo;
    @Autowired
    IOrderKidsExcelT03Repo iOrderKidsExcelT03Repo;
    @Autowired
    IOrderKidsExcelT04Repo iOrderKidsExcelT04Repo;
    @Autowired
    IOrderKidsExcelT05Repo iOrderKidsExcelT05Repo;
    @Autowired
    IOrderKidsExcelT06Repo iOrderKidsExcelT06Repo;
    @Autowired
    IOrderKidsExcelT07Repo iOrderKidsExcelT07Repo;
    @Autowired
    IOrderKidsExcelT08Repo iOrderKidsExcelT08Repo;
    @Autowired
    IOrderKidsExcelT09Repo iOrderKidsExcelT09Repo;
    @Autowired
    IOrderKidsExcelT10Repo iOrderKidsExcelT10Repo;
    @Autowired
    IOrderKidsExcelT11Repo iOrderKidsExcelT11Repo;
    @Autowired
    IOrderKidsExcelT12Repo iOrderKidsExcelT12Repo;
    @Autowired
    ModelMapper modelMapper;

    public List<OrderKidsExcelDTO> findAllOrderKidsExcel(int month) {
        switch (month) {

            case 1:
                List<OrderKidsExcelT01> orderKidsExcelT01s = iOrderKidsExcelT01Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS1 = orderKidsExcelT01s.stream().map(orderKidsExcelT01 -> modelMapper.map(orderKidsExcelT01, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS1;

            case 2:
                List<OrderKidsExcelT02> orderKidsExcelT02s = iOrderKidsExcelT02Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS2 = orderKidsExcelT02s.stream().map(orderKidsExcelT02 -> modelMapper.map(orderKidsExcelT02, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS2;

            case 3:
                List<OrderKidsExcelT03> orderKidsExcelT03s = iOrderKidsExcelT03Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS3 = orderKidsExcelT03s.stream().map(orderKidsExcelT03 -> modelMapper.map(orderKidsExcelT03, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS3;

            case 4:
                List<OrderKidsExcelT04> orderKidsExcelT04s = iOrderKidsExcelT04Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS4 = orderKidsExcelT04s.stream().map(orderKidsExcelT04 -> modelMapper.map(orderKidsExcelT04, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS4;

            case 5:
                List<OrderKidsExcelT05> orderKidsExcelT05s = iOrderKidsExcelT05Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS5 = orderKidsExcelT05s.stream().map(orderKidsExcelT05 -> modelMapper.map(orderKidsExcelT05, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS5;

            case 6:
                List<OrderKidsExcelT06> orderKidsExcelT06s = iOrderKidsExcelT06Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS6 = orderKidsExcelT06s.stream().map(orderKidsExcelT06 -> modelMapper.map(orderKidsExcelT06, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS6;

            case 7:
                List<OrderKidsExcelT07> orderKidsExcelT07s = iOrderKidsExcelT07Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS7 = orderKidsExcelT07s.stream().map(orderKidsExcelT07 -> modelMapper.map(orderKidsExcelT07, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS7;

            case 8:
                List<OrderKidsExcelT08> orderKidsExcelT08s = iOrderKidsExcelT08Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS8 = orderKidsExcelT08s.stream().map(orderKidsExcelT08 -> modelMapper.map(orderKidsExcelT08, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS8;

            case 9:
                List<OrderKidsExcelT09> orderKidsExcelT09s = iOrderKidsExcelT09Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS9 = orderKidsExcelT09s.stream().map(orderKidsExcelT09 -> modelMapper.map(orderKidsExcelT09, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS9;

            case 10:
                List<OrderKidsExcelT10> orderKidsExcelT10s = iOrderKidsExcelT10Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS10 = orderKidsExcelT10s.stream().map(orderKidsExcelT10 -> modelMapper.map(orderKidsExcelT10, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS10;

            case 11:
                List<OrderKidsExcelT11> orderKidsExcelT11s = iOrderKidsExcelT11Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS11 = orderKidsExcelT11s.stream().map(orderKidsExcelT11 -> modelMapper.map(orderKidsExcelT11, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS11;

            case 12:
                List<OrderKidsExcelT12> orderKidsExcelT12s = iOrderKidsExcelT12Repo.findAll();
                List<OrderKidsExcelDTO> orderKidsExcelDTOS12 = orderKidsExcelT12s.stream().map(orderKidsExcelT12 -> modelMapper.map(orderKidsExcelT12, OrderKidsExcelDTO.class))
                        .collect(Collectors.toList());

                return orderKidsExcelDTOS12;

        }
        return null;
    }
}
