package com.xworkz.mani.Service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.mani.ManiDTO.ManiDTO;

public interface ManiService {

	Set<ConstraintViolation<ManiDTO>> ValidateAndSave(ManiDTO dto);
}
