package service;

import model.Settings;

import java.util.List;

public interface ISettingsService {
    List<String> getLanguage();
    List<String> getPageSize();
}
