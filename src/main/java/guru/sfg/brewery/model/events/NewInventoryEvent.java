package guru.sfg.brewery.model.events;

import guru.sfg.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

	private static final long serialVersionUID = -2926966028391559087L;

	public NewInventoryEvent(BeerDto beerDto) {
		super(beerDto);
	}

}