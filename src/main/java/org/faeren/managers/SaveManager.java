package org.faeren.managers;

import org.faeren.devices.Device;
import org.faeren.resources.Resource;
import org.faeren.upgrades.Upgrades;

import java.util.List;

public record SaveManager(List<Resource> resources, List<Device> devices, List<Upgrades> upgrades) {
}
