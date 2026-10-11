package com.Cesde.concesonario.Servicio;

import com.Cesde.concesonario.Dto.FacturasCompletasClienteDTO;

import java.util.List;

public interface IFacturasCompletasService {
    List<FacturasCompletasClienteDTO> obtenerFacturasCompletas(String idcliente);
}
