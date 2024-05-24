package com.ebookteria.identity.mapper;

import com.ebookteria.identity.dto.request.RoleRequest;
import com.ebookteria.identity.dto.response.RoleResponse;
import com.ebookteria.identity.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
