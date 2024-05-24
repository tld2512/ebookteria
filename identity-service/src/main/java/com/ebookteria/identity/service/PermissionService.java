package com.ebookteria.identity.service;

import com.ebookteria.identity.dto.request.PermissionRequest;
import com.ebookteria.identity.dto.response.PermissionResponse;
import com.ebookteria.identity.entity.Permission;
import com.ebookteria.identity.mapper.PermissionMapper;
import com.ebookteria.identity.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        return permissionRepository.findAll()
               .stream()
               .map(permissionMapper::toPermissionResponse)
               .toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
