package com.upc.dentify.services.interfaces.rest.dtos;

import java.util.List;

public record ServiceCatalogResourceFromJson(String service, List<ItemRequiredResourceFromJson> items) {
}
