package service;

import model.Settings;
import repository.ISettingsRepository;
import repository.SettingsRepository;

import java.util.List;

public class SettingsService implements ISettingsService{
ISettingsRepository iSettingsRepository = new SettingsRepository();
    @Override
    public List<String> getLanguage() {
        return iSettingsRepository.getLanguage();
    }

    @Override
    public List<String> getPageSize() {
        return iSettingsRepository.getPageSize();
    }


}
