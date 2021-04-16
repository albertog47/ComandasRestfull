package com.comandas.restfull.service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comandas.restfull.entity.Estado;
import com.comandas.restfull.entity.LineaPedido;
import com.comandas.restfull.entity.Pedido;
import com.comandas.restfull.entity.PedidoVo;
import com.comandas.restfull.exception.ModelNontFoundException;
import com.comandas.restfull.repository.RepositoryEstado;
import com.comandas.restfull.repository.RepositoryLineasPedido;
import com.comandas.restfull.repository.RepositoryPedido;
import com.comandas.restfull.security.enums.EstadosNombre;
@Service
@Transactional
public class ServicePedidoImple implements ServicePedido {

	@Autowired
	RepositoryPedido repositoryPedido;
	@Autowired
	RepositoryLineasPedido repositoryLineasPedido;
	@Autowired
	RepositoryEstado repositoryEstado;
	
	@Override
	public List<Pedido> findAllPedidos() {
		return repositoryPedido.findAll();
	}

	@Override
	public Optional<Pedido> findPedidoById(Long id) {
		Optional<Pedido> pedido = repositoryPedido.findById(id);
		if (!pedido.isPresent()) {
			throw new ModelNontFoundException("Error! El pedido no ha sido encontrado");
		} else {
			return pedido;
		}
	}

	@Override
	public Optional<Pedido>savePedido(PedidoVo pedido) {
		//PedidoVo peRecibido= pedido;
		Set<Estado> estado= new HashSet<>();
		estado.add(repositoryEstado.findByEstadoNombre(EstadosNombre.EN_PROCESO).get());
		Pedido pe=new Pedido(pedido.getNombre(),pedido.getCantidadProductos(),pedido.getImporte(),pedido.getComentarios(), pedido.getTipo_envio(), pedido.getDireccion(), pedido.getTelefono(),pedido.getFecha());
		
		pe.setEstadoPedido(estado);
		Calendar c = Calendar.getInstance();
		pe.setFecha(c);
		pe= repositoryPedido.save(pe);
		List<LineaPedido> lineas=pedido.getLineasPedido();
		for (LineaPedido ln: lineas) {
			ln.setPedido(pe);
			repositoryLineasPedido.save(ln);
		}
		
		
		 
		return repositoryPedido.findById(pe.getId());
	}

	@Override
	public void deletePedido(Long id) {
		if (repositoryPedido.findById(id).isPresent()) {
			repositoryPedido.deleteById(id);

		} else {

			throw new ModelNontFoundException("Error! El Pedido no existe");
		}

		
	}

	@Override
	public Pedido updatePedido(Pedido pedido) {
		if (repositoryPedido.findById(pedido.getId()).isPresent()) {
			return repositoryPedido.save(pedido);
		} else {

			throw new ModelNontFoundException("Error! El pedido no existe");
		}
	}

	@Override
	public Optional<List<Pedido>> findPedidoByNombre(String nombre) {
		Optional<List<Pedido>> pedido = repositoryPedido.findByNombre(nombre);
		if (!pedido.isPresent()) {
			throw new ModelNontFoundException("Error! El pedido no ha sido encontrado");
		} else {
			return pedido;
		}
	}

	

}
