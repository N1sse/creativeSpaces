package ac.cr.ucr.creativeSpaces.repository;

import java.util.List;

import ac.cr.ucr.creativeSpaces.model.Creative;

public interface IRegisterCreative {
    public Creative addSpaces(Creative creative);
    public List <Creative> getAllCreative();
    public Creative getSpaces(Integer idCreative);
    public Creative deleteSpaces (Integer idCreative);
    public Creative editSpaces (Integer idCreative, Creative spacesEdit);
}
