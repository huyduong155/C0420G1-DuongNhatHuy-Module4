package repository;

import model.Settings;

import java.util.List;

public interface ISettingsRepository {
    List<String> getLanguage();
    List<String> getPageSize();

}
