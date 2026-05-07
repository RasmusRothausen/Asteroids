package dk.sdu.mmmi.cbse.common.util;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public enum ServiceLocator {
    INSTANCE;

    private ModuleLayer pluginLayer = null;

    public void loadPlugins(String pluginPath) {
        Path path = Paths.get(pluginPath);
        ModuleFinder finder = ModuleFinder.of(path);
        ModuleLayer parent = ModuleLayer.boot();
        Configuration config = parent.configuration()
                .resolveAndBind(finder, ModuleFinder.of(), List.of());
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        pluginLayer = parent.defineModulesWithOneLoader(config, loader);
    }

    public <T> Collection<T> locateAll(Class<T> service) {
        if (pluginLayer != null) {
            return ServiceLoader.load(pluginLayer, service)
                    .stream()
                    .map(ServiceLoader.Provider::get)
                    .collect(Collectors.toList());
        }
        return ServiceLoader.load(service)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}