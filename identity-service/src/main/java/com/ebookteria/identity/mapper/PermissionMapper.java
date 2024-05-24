package com.ebookteria.identity.mapper;

import com.ebookteria.identity.dto.request.PermissionRequest;
import com.ebookteria.identity.dto.response.PermissionResponse;
import com.ebookteria.identity.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
