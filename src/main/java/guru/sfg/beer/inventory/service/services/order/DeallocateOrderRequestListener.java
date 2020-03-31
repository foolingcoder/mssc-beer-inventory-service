package guru.sfg.beer.inventory.service.services.order;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.services.AllocationService;
import guru.sfg.brewery.model.events.DeallocateOrderRequest;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class DeallocateOrderRequestListener {

	private final AllocationService allocationService;

	@JmsListener(destination = JmsConfig.DEALLOCATE_ORDER_QUEUE)
	public void listen(DeallocateOrderRequest request) {

		allocationService.deallocateOrder(request.getBeerOrderDto());
	}

}
