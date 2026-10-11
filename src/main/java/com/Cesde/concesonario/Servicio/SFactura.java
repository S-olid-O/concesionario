package com.Cesde.concesonario.Servicio;

import com.Cesde.concesonario.Dto.FacturasCompletasClienteDTO;
import com.Cesde.concesonario.Mapper.IFacturaCompletaMapper;
import com.Cesde.concesonario.Repositorio.IFactura;
import com.Cesde.concesonario.Repositorio.IFacturasCompletasClienteProjecion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SFactura implements IFacturasCompletasService {
    // Inyectar interfaces
    private final IFacturaCompletaMapper iFacturaCompletaMapper;
    private final IFactura iFactura;

    // Constructor
    public SFactura(IFacturaCompletaMapper iFacturaCompletaMapper, IFactura iFactura) {
        this.iFacturaCompletaMapper = iFacturaCompletaMapper;
        this.iFactura = iFactura;
    }

    @Override
    public List<FacturasCompletasClienteDTO> obtenerFacturasCompletas(String idcliente) {
        // Llevar el resultado de la consulta nativa a la proyeccion
        List<IFacturasCompletasClienteProjecion> proyeccion=iFactura.consultaCompletaFacturaCliente(idcliente);
        // Pasa la proyeccion al Mapper que a su vez devuelve una lista DTO
        return iFacturaCompletaMapper.toDTOList(proyeccion);
    }
}
